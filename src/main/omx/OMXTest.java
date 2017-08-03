package omx;

/**
 * Test basic OMX Matrix Reader and writer
 * java -classpath "omx.jar" -Djava.library.path="jhdfdllFolder" omx.OMXTest
 * requires omx.jar in classpath and jhdf5.dll,jhdf.dll in the java.library.path
 * @author    Ben Stabler
 * @version   1.0, 02/11/15
 */
public class OMXTest {

	private OMXTest() {}
	
	public static void main(String[] args) {
		
		//create matrix
		int numzones = 5000;
		long start = System.nanoTime();
		OmxFile omxfile = new OmxFile("test.omx");
		int[] shape = new int[2];
		shape[0] = numzones;
		shape[1] = numzones;	
		omxfile.openNew(shape);
		
		//create matrix
		double[][] valuesDouble = new double[shape[0]][shape[1]];
		for (int i = 0 ; i < valuesDouble.length; i++) {
			for (int j = 0 ; j < valuesDouble[0].length; j++) {
				valuesDouble[i][j] = i*j;
			}
		}
		
		//add matrix
		OmxMatrix.OmxDoubleMatrix mat = new OmxMatrix.OmxDoubleMatrix("test", valuesDouble, 99999.0);
		omxfile.addMatrix(mat);
		
		//add zone names
		int[] zoneNames = new int[shape[0]];
		for (int j = 0 ; j < zoneNames.length; j++) {
			zoneNames[j] = j + 100;
		}
		OmxLookup.OmxIntLookup omxZoneNums = new OmxLookup.OmxIntLookup("NO", zoneNames, 0);
		omxfile.addLookup(omxZoneNums);

		long diff = System.nanoTime() - start;
		double diffsec = (diff / 1000000000.0);
		System.out.println("Create matrix " + String.valueOf(shape[0]) + " x " + String.valueOf(shape[1]) + ": " + String.valueOf(diffsec));

		//write matrix
		start = System.nanoTime();
		omxfile.save();
		diff = System.nanoTime() - start;
		diffsec = (diff / 1000000000.0);
		System.out.println("Write matrix " + String.valueOf(shape[0]) + " x " + String.valueOf(shape[1]) + ": " + String.valueOf(diffsec));
		
		//read matrix
		start = System.nanoTime();
		OmxFile omxfileIn = new OmxFile("test.omx");
		omxfileIn.openReadOnly();
		OmxMatrix.OmxDoubleMatrix omxMat = (OmxMatrix.OmxDoubleMatrix)omxfileIn.getMatrix("test");
		double[][] values = omxMat.getData();
		
		diff = System.nanoTime() - start;
		diffsec = (diff / 1000000000.0);
		System.out.println("Read matrix " + String.valueOf(shape[0]) + " x " + String.valueOf(shape[1]) + ": " + String.valueOf(diffsec));
		
		//read matrix items 
		//for (int i = 0 ; i < values.length; i++) {
		//	for (int j = 0 ; j < values[0].length; j++) {
		//		System.out.println(values[i][j]);
		//	}
		//}
		
		//read zone names
		//OmxLookup.OmxIntLookup zoneLabels = (OmxLookup.OmxIntLookup)omxfileIn.getLookup("NO");
		//for (int j = 0 ; j < zoneLabels.getLength(); j++) {
		//	System.out.println(zoneLabels.getLookup()[j]);
		//}
		//omxfileIn.close();
		
	}

}
