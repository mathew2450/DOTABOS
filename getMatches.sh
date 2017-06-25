#!/bin/bash    
# Source env variable
source ./export.bash
_now=$(date "+%Y.%m.%d-%H.%M.%S")
echo "Getting Replays"
curl --get 'http://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/v001/?key=A15BA1CAED87271BB1B6567D7D493227&skill=2&game_mode=1&min_players=10&hero_id=89&matches_requested=100' > test/matchList.txt
grep match_id test/matchList.txt > test/match_ids.txt
grep -Eo '[0-9]{1,}' test/match_ids.txt > test/match_ids_only.txt
rm test/match_ids.txt
filename="test/match_ids_only.txt"
while read -r line
do
  export VAR=$line
  ./getMatchDetails.sh
  sleep 10

done < "$filename"
./getReplays.sh
gnome-terminal -e "bash -c \"cd ../bot\ (3rd\ copy); ./getMatches.sh; exec bash\""
 
