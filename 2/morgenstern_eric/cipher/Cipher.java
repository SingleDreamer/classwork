import java.util.*;
import java.io.*;

public class Cipher{
    
    public String encode(String s, int n){
	String u="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String l="abcdefghijklmnopqrstuvwxyz";
	for (int i=0;i<s.length();i++){
	    //Below will lowercase the string	
	    if (u.indexOf(s.substring(i,i+1))!=-1){
		String a="";
		int q=u.indexOf(s.substring(i,i+1));
		a=s.substring(0,i)+l.substring(q,q+1)+s.substring(i+1);
		s=a;}
	    
	    //Below will encode the string
	    String a="";
	    if (l.indexOf(s.substring(i,i+1))!=-1){
		a=s.substring(0,i);
		int q=(l.indexOf(s.substring(i,i+1))+n)%26;
		a=a+l.substring(q,q+1)+s.substring(i+1);
		s=a;}
	}
	return s;
    }

    public String rotate(String filename, int n){
	String u="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String l="abcdefghijklmnopqrstuvwxyz";
	String s="";
	try{
	    Scanner sc=new Scanner (new File(filename));
	    while (sc.hasNext()){
		String q =sc.nextLine();
		q=q.toLowerCase();
	        s=s+q;
	    }
	} catch (Exception e) {System.out.println(e);}
	for (int i=0;i<s.length();i++){
	    //Below will encode the string
	    String a="";
	    if (l.indexOf(s.substring(i,i+1))!=-1){
		a=s.substring(0,i);
		int q=(l.indexOf(s.substring(i,i+1))+n)%26;
		a=a+l.substring(q,q+1)+s.substring(i+1);
		s=a;}
	}
	return s;
    }
    
    private double[] CorpusFreqs=new double[26];

    private void buildCorpusFreq(String filename){
	int q=0;
	try{
	    Scanner sc=new Scanner (new File(filename));
	    while (sc.hasNext()){
		String s =sc.nextLine();
		s=s.toLowerCase();
		for (int i=0;i<s.length();i++){
		    char c=s.charAt(i);
		    if (c>='a' && c<='z'){
			CorpusFreqs[c-'a']=CorpusFreqs[c-'a']+1;
			q=q+1;}
		}
	    }
	} catch (Exception e) {System.out.println(e);}
	for (int i=0;i<CorpusFreqs.length;i++){
	    CorpusFreqs[i]=CorpusFreqs[i]/q;}
	System.out.println(Arrays.toString(CorpusFreqs));
    }

    private void buildCorpusFreq2(String file){
	int q=0;
	file=file.toLowerCase();
	for (int i=0;i<file.length();i++){
	    char c=file.charAt(i);
	    if (c>='a' && c<='z'){
		CorpusFreqs[c-'a']=CorpusFreqs[c-'a']+1;
		q=q+1;}
	}
	for (int i=0;i<CorpusFreqs.length;i++){
	    CorpusFreqs[i]=CorpusFreqs[i]/q;}
    }
    
    private double[] buildCorpusFreq3(String filename){
	int q=0;
	try{
	    Scanner sc=new Scanner (new File(filename));
	    while (sc.hasNext()){
		String s =sc.nextLine();
		s=s.toLowerCase();
		for (int i=0;i<s.length();i++){
		    char c=s.charAt(i);
		    if (c>='a' && c<='z'){
			CorpusFreqs[c-'a']=CorpusFreqs[c-'a']+1;
			q=q+1;}
		}
	    }
	} catch (Exception e) {System.out.println(e);}
	for (int i=0;i<CorpusFreqs.length;i++){
	    CorpusFreqs[i]=CorpusFreqs[i]/q;}
	return CorpusFreqs;
    }

    public int decode(String encodedfile, double[] decodedfile){
	int offset=-1;
	double LowestDistance=Math.sqrt(26);
	System.out.println(LowestDistance);
	for (int i=0;i<26;i++){
	    buildCorpusFreq2(encode(encodedfile,i));
	    double ThisDistance=0.0;
	    for (int w=0;w<26;w++){
		ThisDistance=ThisDistance+Math.pow((CorpusFreqs[w]-decodedfile[w]),2);
		ThisDistance=Math.sqrt(ThisDistance);
		if (ThisDistance<LowestDistance){
		LowestDistance=ThisDistance;
		offset=(26-i)%26;}
	    }
	}
	return offset;
    }
    
    public static void main(String[] args){
	Cipher c=new Cipher();
	Cipher d=new Cipher();
	System.out.println(c.encode("hello",3));
	System.out.println(c.encode("abcxyz",3));
	System.out.println(c.encode("hi there!",1));
	System.out.println(c.encode("HI THERE!",1));
       	System.out.println(c.decode(c.rotate("englishbook.txt",8),d.buildCorpusFreq3("englishbook.txt")));
    }  
}
