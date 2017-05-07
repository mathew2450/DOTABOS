plotRatios <- function() {
  files <- list.files(pattern="*.csv")
  df <- data.frame()
  for(i in 1:length(files)){
    data <- read.csv(files[i],head=TRUE,sep=",")
    print(i/length(files))
    #print(data$hero)
    radiantHero <- subset(data, hero == "CDOTA_Unit_Hero_AntiMage" & winner == " yes", select=c(frame, ratio)) 
    #direHero <- subset(data, hero == "CDOTA_Unit_Hero_Tiny", select=c(frame, ratio))
    df <- rbind(df, radiantHero)
  }
  #library(zoo)
  
  time <- df$frame
  radiantRatio <- df$ratio
  #direRatio <- direHero$ratio
  #mav <- function(x,n=5){filter(x,rep(1/n,n), sides=2)}
  #par(cex=.1)
  plot(((time)/60), radiantRatio, ylim=c(-.01, 1), col="limegreen", pch='.')
  #abline(lm(radiantRatio ~ ((time)/60)))
  #radiantRation.lm = lm((((df$frame)/60)~df$ratio), data=df) 
  #summary(radiantRation.lm)
  #abline(radiantRation.lm)
  lines(lowess((time)/60,radiantRatio), col="blue") # lowess line (x,y) 
  #abline(0, 1)
  #mov.avg <- rollmean(radiantRatio, 5, fill=NA)
  #lines(time/60, mov.avg, col="orange", lwd=2)
  # add minor ticks
  #Hmisc::minor.tick(nx=5, ny=20, tick.ratio=.2)
  #lines(((time)/60), mav(radiantRatio))
  #lines(((time)/60), mav(direRatio), col="red")
}

plotRatios()




