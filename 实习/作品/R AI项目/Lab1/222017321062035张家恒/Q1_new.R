
x<-c(2,4,7,NA,12,19,NA,21,20, 30, 50, 75)
x<-na.exclude(x)
m<-mean(x)

l<-length(x)
s<-0
l<-l-1
for (i in 1:10) { s<-s+  (x[i]-m)*(x[i]-m)/(l)
}
view(s)


