
Java API for [OMX](https://github.com/osPlanning/omx)

# Examples
There are two examples:

```
java.exe -classpath omx.jar -Djava.library.path=./lib/win64/ omx.OMXTest

java.exe -classpath omx.jar -Djava.library.path=./lib/win64/ omx.OMXFile
```

# Required binaries for using the jar

The binary libraries in /lib/ are required to run the model, and must be present on the java
 library path. For example, on a 64-bit window platform:

    java -classpath omx.jar -Djava.library.path=./lib/win64/ omx.OmxFile

# Required HDF5 libraries for building the jar

To build with the included omx.aml ant script, you need 
the [HD5 2.8](http://www.hdfgroup.org/ftp/HDF5/releases/HDF-JAVA/HDF-JAVA-2.8/bin/) libraries.


