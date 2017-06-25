data <- read.csv("ratios.csv",head=TRUE,sep=",")
radiantHero <- subset(data, hero == "CDOTA_Unit_Hero_AntiMage", select=c(frame, ratio)) 
direHero <- subset(data, hero == "CDOTA_Unit_Hero_Tiny", select=c(frame, ratio))
time <- radiantHero$frame
radiantRatio <- radiantHero$ratio
direRatio <- direHero$ratio

mav <- function(x,n=5){filter(x,rep(1/n,n), sides=2)}
plot(((time)/60), radiantRatio, type="n", col="limegreen")
# add minor ticks
Hmisc::minor.tick(nx=5, ny=20, tick.ratio=.2)
lines(((time)/60), mav(radiantRatio))
lines(((time)/60), mav(direRatio), col="red")

