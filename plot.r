data <- read.csv("./slot7.csv",head=TRUE,sep=",")
time <- data$frame
gold <- data$gold

# assumes that the first factor thing is the empty string
new_items <- data$new_item
# basically set all the values that aren't empty strings
# to the maximimum value on the graph
item_levels <- rep_len(max(gold), length(levels(new_items)))
item_levels[1] <- 0
levels(new_items) <- item_levels
# this converts it all into numbers instead of factors
new_items <- as.numeric(levels(new_items))[new_items]

plot(time/60, gold, type="n")
lines(time/60, gold, type="l")
lines(time/60, new_items, col="#0000FF",type="h")

readline("Press <Enter> to continue")
