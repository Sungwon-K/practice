#include<stdio.h>                                                                                                                                                                                                                                                                                                                                                                                                                   
#include<string.h>
#include<malloc.h>
#include<time.h>
//#include "myheader.h"

#define PI 3.1415926535
#define STR "원의 면적을 계산했습니다.\n"
#define END_MSG printf("프로그램이 종료되었습니다.\n\n")

void func();

int a;


int main(int argc, char* argv[])
{
	//메인함수 매개변수
	/*
	char str[200];
	FILE* rfp;

	if (argc != 2)
	{
		printf("---매개변수를 1개 사용하세요---\n");
		return -1;
	}

	fopen_s(&rfp, argv[1], "r");

	for (;;)
	{
		fgets(str, 199, rfp);
		if (feof(rfp))
			break;
		printf("%s", str);
	}

	fclose(rfp);
	*/

	//헤더 파일
	/*
	func(10);
	*/

	//c파일 호출
	/*
	func1();
	func2();
	*/
	
	//define문 사용
	/*
	printf("반지름이 10인 원의 면적 : %10.5d\n", 10 * 10 * PI);

	printf(STR);
	END_MSG;
	*/

	//extern 예약어 사용
	/*
	a = 100;
	func();
	*/

	//
	char str[200];
	FILE* rfp, *wfp;

	if (argc != 3)
	{
		printf("\n--매개변수를 2개 사용하세요--\n");
		return 0;
	}

	fopen_s(&rfp, argv[1], "r");
	fopen_s(&wfp, argv[2], "w");

	for (;;)
	{
		fgets(str, 199, rfp);

		if (feof(rfp))
			break;

		fputs(str, wfp);
	}

	fclose(rfp);
	fclose(wfp);
}




