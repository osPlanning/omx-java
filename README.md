
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

# Maven

A maven release is hosted by the [Professorship for Modeling Spatial Mobility](https://www.bgu.tum.de/en/msm/start-page/) at TU Munich. You can access it by defining the following repository iny our .pom:
```
<repositories>
  <repository>
    <id>msmobility-msm</id>
    <url>https://dl.cloudsmith.io/public/msmobility/msm/maven/</url>
    <releases>
      <enabled>true</enabled>
      <updatePolicy>always</updatePolicy>
    </releases>
    <snapshots>
      <enabled>true</enabled>
      <updatePolicy>always</updatePolicy>
    </snapshots>
  </repository>
</repositories>
```
In the dependencies section of you. pom file add:
```
<dependency>
  <groupId>omx</groupId>
  <artifactId>omx</artifactId>
  <version>2</version>
</dependency>
```

Please note that this does not include the native hdf5 libraries that you will need to setup independently. They can be found in the release/lib folder of this repository.

