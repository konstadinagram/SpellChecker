import java.io.*;
import java.nio.*;
import java.nio.charset.*;
class test {
public static void main (String[] args){

try {
BufferedReader in = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-7"));
String str = "";
while (str != null) {
System.out.print("> prompt ");
str = in.readLine();
// Create the encoder and decoder for ISO-8859-7
Charset charset = Charset.forName("ISO-8859-7");
CharsetDecoder decoder = charset.newDecoder();
CharsetEncoder encoder = charset.newEncoder();

// Convert a string to ISO-LATIN-7 bytes in a ByteBuffer
// The new ByteBuffer is ready to be read.
ByteBuffer bbuf = encoder.encode(CharBuffer.wrap(str));

// Convert ISO-LATIN-7 bytes in a ByteBuffer to a character ByteBuffer and then to a string.
// The new ByteBuffer is ready to be read.
CharBuffer cbuf = decoder.decode(bbuf);
String s = cbuf.toString();
System.out.println(s);
}
} catch (IOException e) {
}
}
} 