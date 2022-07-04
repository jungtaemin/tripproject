# 자유게시판 프로젝트
JPA와 시큐리티를 학습후 그것들을 적용하여 게시판을 만들었습니다.<br/>
crud를 다 적용시킬수 있음을 보여주려고 노력하였습니다.
# 목차
 - [사용 기술](https://github.com/jungtaemin/tripproject#사용-기술)
 - [프로젝트 설계](https://github.com/jungtaemin/tripproject#프로젝트-설계)
 - [패키징 구조](https://github.com/jungtaemin/tripproject#패키징-구조)
 - [핵심 기능](https://github.com/jungtaemin/tripproject#핵심-기능)
 - [프로젝트 후기](https://github.com/jungtaemin/tripproject#프로젝트-후기)
# 사용 기술


**프레임워크 / 라이브러리**

- java 11 openjdk
- springboot
- SpringBoot Security
- SpringBoot Jpa

**Build tool**
- Gradle

**Data base**
- mysql

**프론트엔드**
- Thymeleaf
- Bootstrap 5
- html/css

**라이브러리**
- Lombok
- MapStruct
# 프로젝트 설계

# 패키징 구조
![03](https://user-images.githubusercontent.com/96284736/177046629-2abea7a7-b9b4-4df9-a6a8-eb7ef30173fb.png)

**헥사고날 아키텍처**<br/>
내 프로젝트의 article의 패키징<br/>
![zzzzz](https://user-images.githubusercontent.com/96284736/177046924-70c734bc-8157-4252-9852-175eaed14f1d.PNG)<br/>
프로젝트 구조를 헥사고날 아키텍처로 하였습니다.

아키텍처 확장에 용이하고 SOLID 원칙을 쉽게 적용할 수 있는 등 장점이 많아 헥사고날 아키텍처를 적용하였습니다.




# 핵심 기능

## OAuth2 소셜 로그인
![dddd](https://user-images.githubusercontent.com/96284736/177117919-f8bfda71-3dc3-4d8a-9d14-97cee6a7419d.PNG)

![ddsda](https://user-images.githubusercontent.com/96284736/177117932-7a2b073d-689c-4aff-b873-879f190402a8.PNG)

![222222](https://user-images.githubusercontent.com/96284736/177118328-d9453773-4556-4a9d-9eb2-28cc04083ab7.PNG)

소셜 로그인을 구현하기위해 스프링시큐리티와 OAuth2를 사용하였습니다. 

## validation
![vali1](https://user-images.githubusercontent.com/96284736/177123414-5d69066c-b1bb-4dc0-9798-da980709a0e1.PNG)
![vali2](https://user-images.githubusercontent.com/96284736/177123421-cb6dbcd7-b026-4a70-8169-37dccd859909.PNG)

## 글쓰기
![1p](https://user-images.githubusercontent.com/96284736/177152969-b177ce42-365c-45bc-8529-4c185846e29a.PNG)
![2p](https://user-images.githubusercontent.com/96284736/177152976-6c0c1fba-e31f-4cfc-81eb-9d8075f19d5a.PNG)
![게시판~](https://user-images.githubusercontent.com/96284736/177153177-59eee828-7906-4dd1-9034-1a1551b321e0.PNG)

## CRUD
![new](https://user-images.githubusercontent.com/96284736/177153407-665aa189-32ca-4d18-bac0-6ef263884a72.PNG)


``` 내 글 수정/삭제를 누르면 로그인된 아이디로 쓴 글만 게시판별로 나누어서 보여줍니다. ```


![수정~~](https://user-images.githubusercontent.com/96284736/177154490-762396a5-436c-4054-9520-2176380cc3f3.PNG)


``` 수정 버튼을 누르면 작성했던 글을 수정할 수 있습니다.```


![수정함2](https://user-images.githubusercontent.com/96284736/177154506-f4b46468-fb6e-44a1-9674-29921cf707bb.PNG)
![수정함3](https://user-images.githubusercontent.com/96284736/177154540-0bb2ab6f-4f9c-475e-a3eb-c874a9aad430.PNG)



``` 수정 버튼을 눌러 수정한 이미지 ```


## 내 글 삭제
![삭제함1](https://user-images.githubusercontent.com/96284736/177154769-57db37f5-25ce-4269-8cd4-4fc1d90d6fd9.PNG)
![삭제함2](https://user-images.githubusercontent.com/96284736/177154777-6c556a5f-754a-40d8-90a8-5ebfbb47981b.PNG)
## 검색
![검색함](https://user-images.githubusercontent.com/96284736/177154955-63e6cd20-7890-4cbb-aad6-15a454f40ef1.PNG)
![검색함2](https://user-images.githubusercontent.com/96284736/177154958-4c1ae32b-cc7a-43fc-ad7c-03bd1237cdf3.PNG)


``` 쿼리 메소드 @Query 어노테이션을 사용 like %:??% 를 써서 제목과 내용으로 검색되게 만들었습니다. ```


## 최신글보기
![최신순글](https://user-images.githubusercontent.com/96284736/177155177-fae61f5e-61ff-45ed-8dac-35ea9ac1385f.PNG)


``` 메소드 이름으로 자동으로 쿼리를 생성하는 jpa의 기능으로 List<Article>findTop5ByOrderByIdDesc() 메소드를 만들어 등록된 게시글중 최근 5개의 게시글을 제목과 작성일로 게시판별로 보여줍니다.클릭하여 게시글내용을 볼수있는 페이지로 이동.```


# 프로젝트 후기

