# Histogram_NER_Hadoop_HDFS

This is a simplified version of the Histogram_NER_Haddop project.

This project is a Hadoop implementation in Java of the named entities occurrences counted in tweets. For NER (Name Entity Recognition) has been used [lingPipe](http://alias-i.com/lingpipe/demos/tutorial/read-me.html) library.

To run this project is necessary to give the right arguments:

**args[0] = tweets** --> it is an containing the input tweet .xml files. It can contain only <TweetText> tag.
  
**args[1] = output** --> it is a directory that will be created from the program after its execution.

**args[2] = model** --> it is a directory containing one of the .AbstractCharLmRescoringChunker [models](http://alias-i.com/lingpipe/web/models.html) for NER avaiable to the lingPipe      library. The model in the _parallel18computing/Histogram_NER_Hadoop_HDFS/model_ directory is able to recognize PERSON, LOCATION and ORGANIZATION.


This program don't create the histograms of the occurrences of named entity, but it only detects the named entities in the mapper phase and counts them in the reduce phase. 


