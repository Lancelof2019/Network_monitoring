# Network_monitoring
One tool to catch the network packages and make analysis to get the samples from set
1)In this project,the system are divided into ICMP,TCPIP,UCP model,each model can be processed concurrecntly processed using java processes.
2)In a given time ,the data records will be stored in memory and they will be sampled by using algorithm Reservoir Sampling .There is one threshhold value which defines 
how many items of data can be accommodated at that time.
3)The sampled data will be processed and wrote into local file as backup,in the file people can see which IP  accesses  local server the most frequently and show the detail of the access information.
Furthermore people can see the distributed information of the top ten data.
