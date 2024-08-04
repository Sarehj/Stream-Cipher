import java.io.*;

public class StreamCipher{
    public static void main(String[] args) {
        
        String key = args[0];  //first arg
        long keyL = 0;                     
        FileInputStream inputStream = null;  
        FileOutputStream outputStream = null; 
   
        
        if (args.length !=3){
            System.out.println("3 arguments need <key> <infile> <outfile>");
            System.exit(1);
        }
    
        try {
            keyL = Long.parseLong(key); } 

        catch (NumberFormatException e) {
                System.out.println("The key is not valid"); 
                System.exit(1);
        }
        
        try {
            if (Long.parseLong(key) == 0) 
                throw new ArithmeticException();
         } 
         
        catch (ArithmeticException arithmetic) {
        	System.out.println("The key is invalid");
            System.exit(1);
        }

        //open input File
        try {
           
            File input = new File(args[1]);   //second arg: input file (read)
            inputStream = new FileInputStream(input);

            File output = new File(args[2]);   //last arg: output file (write)
            outputStream = new FileOutputStream(output);    
       } 
          catch(FileNotFoundException e){ 
            System.out.println("File does not found "); 
            System.exit(1);
        }
       
        MyRandom random = new MyRandom(keyL); 
       
        //Xor input with random key and write to output file
        try {   
            int k;
            int xor;
            int inputBR = read(inputStream);
          
            while (inputBR != -1) {
                 k = random.next(256);
                 xor = inputBR ^ k;
                 outputStream.write(xor);
                 inputBR = read(inputStream);
            }
           
            // flush the stream
            outputStream.flush();
            inputStream.close();
            outputStream.close();
            System.exit(0);
        
        }    
        
        catch (IOException e){
            System.out.println("Something wrong");
            System.exit(1);
        }
    
    }

    private static int read(InputStream inputStream){
        int inputBR = 0;
        try{
            inputBR = inputStream.read();
        }
        catch (IOException e){
            System.out.println("Can not read");
        }
        return inputBR;
     }

}
