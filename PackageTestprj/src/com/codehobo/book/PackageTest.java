package com.codehobo.book;

public class PackageTest {

	public static void main(String[] args) {
		System.out.println("Hello? package");
	}
}


// cmd 창으로 패키지 실행해보기!
// c:\Users > java com.codehobo.book.PackageTest // Errror!!
// 패키지 루트( 패키지 시작 폴더의 상위 폴더)로 이동 후 다시 작성해보자!
// class 파일이 있는 루트 > c:\User\java\PackageTestprj\bin\com\codehobo\book
// 패키지 루트는 c:\User\java\PackageTestprj\bin 이거다.
// 래키지 루트로 이동 후 java com.codehobo.book.PackageTest 실행 // 성공!!