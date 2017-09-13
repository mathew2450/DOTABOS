import csv
import os
import fnmatch

filesList = []
startingItemSets = []
commonItemSets = []
namesList = ['abaddon', 'abyssal_underlord', 'alchemist', 'ancient_apparition', 'antimage', 'arc_warden', 'axe', 'bane', 'batrider', 'beastmaster', 'bloodseeker', 'bounty_hunter', 'brewmaster', 'bristleback', 'broodmother', 'centaur', 'chaos_knight', 'chen', 'clinkz', 'crystal_maiden', 'dark_seer', 'dazzle', 'death_prophet', 'disruptor', 'doom_bringer', 'dragon_knight', 'drow_ranger', 'earth_spirit', 'earthshaker', 'elder_titan', 'ember_spirit', 'enchantress', 'enigma', 'faceless_void', 'furion', 'gyrocopter', 'huskar', 'invoker', 'jakiro', 'juggernaut', 'keeper_of_the_light', 'kunkka', 'legion_commander', 'leshrac', 'lich', 'life_stealer', 'lina', 'lion', 'lone_druid', 'luna', 'lycan', 'magnataur', 'medusa', 'meepo', 'mirana', 'morphling', 'naga_siren', 'necrolyte', 'nevermore', 'night_stalker', 'nyx_assassin', 'obsidian_destroyer', 'ogre_magi', 'omniknight', 'oracle', 'phantom_assassin', 'phantom_lancer', 'phoenix', 'puck', 'pudge', 'pugna', 'queenofpain', 'rattletrap', 'razor', 'riki', 'rubick', 'sand_king', 'shadow_demon', 'shadow_shaman', 'shredder', 'silencer', 'skeleton_king', 'skywrath_mage', 'slardar', 'slark', 'sniper', 'spectre', 'spirit_breaker', 'storm_spirit', 'sven', 'techies', 'templar_assassin', 'terrorblade', 'tidehunter', 'tinker', 'tiny', 'treant', 'troll_warlord', 'tusk', 'undying', 'ursa', 'vengefulspirit', 'venomancer', 'viper', 'visage', 'warlock', 'weaver', 'windrunner', 'winter_wyvern', 'wisp', 'witch_doctor', 'zuus']
while True:
    heroInput = input('Hero Name: ')
    if heroInput not in namesList:
        print("Invalid hero name. Make sure you're using the internal name for the hero.")
        continue
    else:
        heroName = 'hero_' + heroInput
        break

#Makes a list of CSV file names in a directory
for file in os.listdir("/home/hunter/Documents/csvFiles"): #Change this dir to be dynamic
    if fnmatch.fnmatch(file, "*.csv"):
        filesList.append(file)

#For every file in the directory, reads and parses the starting items for !one hero
count = 0
for i in filesList:
    fileDir = "/home/hunter/Documents/csvFiles/" + filesList[count]
    with open(fileDir) as csvfile:
        readCSV = list(csv.DictReader(csvfile))
    startingItems = []
    for d in readCSV:
        if d['hero'] == 'hero_antimage' \
           and float(d['frame']) < 0 \
           and len(d['new_item']) > 0:
            newItemLine = d['new_item'] #This is where parsing occurs
            translation_table = dict.fromkeys(map(ord, '[]',), None)
            newItemLine = newItemLine.translate(translation_table)
            newItems = newItemLine.split()
            for i in newItems:
                if i == "item_tango_single":
                    pass #removes gifted tangos
                else:
                    i = i[5:]
                    startingItems.append(i)
    startingItems.sort()
    if len(startingItems) > 0:
        print('Game ' + str(count+1) + ':')
        print(startingItems)
    if startingItemSets.count(startingItems) > 1 and startingItems not in commonItemSets:
        commonItemSets.append(startingItems)
    if len(startingItems) > 0:
        startingItemSets.append(startingItems)
    count += 1

print('Common Sets:')
iterator = 0
if len(commonItemSets) > 0:
    for i in commonItemSets:
        print(i, end=' ')
        print(startingItemSets.count(commonItemSets[iterator]))
        iterator += 1
else:
    print("None. May need to get more replays.")
