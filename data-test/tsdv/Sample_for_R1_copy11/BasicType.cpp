


int IntTest(int x);

signed int SignedIntTest(signed int x);

short ShortTest(short x);

signed short SignedShortTest(signed short x){
	if (x > 0)
		return 1;
	else
		return 0;

}

short int ShortIntTest(short int x);

signed short int SignedShortIntTest(signed short int x){

	if (x > 0)
		return 1;
	else
		return 0;

}

long LongTest(long x);

signed long SignedLongTest(signed long x);

long int LongIntTest(long int x);

signed long int SignedLongIntTest(signed long int x);

long long LongLongTest(long long x);

signed long long SignedLongLongTest(signed long long x);

long long int LongLongIntTest(long long int x);

signed long long int SignedLongLongIntTest(signed long long int x);



unsigned int UnsignedIntTest(unsigned int x){
	return x;
}

unsigned UnsignedTest(unsigned x){
	return x;
}

unsigned short int UnsignedShortIntTest(unsigned short int x){
	return x;
}

unsigned short UnsignedShortTest(unsigned short x){
	return x;
}

unsigned long int UnsignedLongIntTest(unsigned long int x){
	return x;
}

unsigned long UnsignedLongTest(unsigned long x){
	return x;
}

unsigned long long int UnsignedLongLongIntTest(unsigned long long int x){
	return x;
}

unsigned long long UnsignedLongLongTest(unsigned long long x){
	return x;
}



bool BoolTest(bool x){
	if (x)
		return x;
	else
		return !x;
}



char CharTest(char x){

	if (x > 'A')
		return 'B';
	else
		return 'C';
}

signed char SignedCharTest(signed char x){

	if (x > 'A')
		return 'B';
	else
		return 'C';
}

unsigned char UnsigedCharTest(unsigned char x){

	if (x > 'A')
		return 'B';
	else
		return 'C';
}



float FloatTest(float x){

	if (x > 0.0)
		return 1.1;
	else
		return 0.1;
}

double DoubleTest(double x){

	if (x > 0.0)
		return 1.1;
	else
		return 0.1;
}

long double LongDoubleTest(long double x){

	if (x > 0.0)
		return 1.1;
	else
		return 0.1;
}



















#include <string>#include <iostream>#include <fstream>#include <stdlib.h>using namespace std;void writeContentToFile(char* path, string content){ofstream myfile;myfile.open(path);myfile << content;myfile.close();}string build = "";bool mark(string append){build += append + "\n";writeContentToFile("D:/cft4cpp-core/data-test/tsdv/Sample_for_R1_copy11/0.txt", build);return true;}int IntTest(int x){mark("statement={###line-of-blockin-function=1###openning-function=true");
	if (mark("line-in-function=3###offset=28###statement=x > 0###control-block=if") && (x > 0)) {
				mark("line-in-function=4###offset=38###statement=return 1;");return 1;
	}
	else {
				mark("line-in-function=6###offset=58###statement=return 0;");return 0;
	}

mark("statement=}###line-of-blockin-function=1");}int main(){try{int x=-1;IntTest(x); }catch(exception& error){build="Phat hien loi runtime";}return 0;}
