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
```프로젝트 구조를 헥사고날 아키텍처로 하였습니다.```

```아키텍처 확장에 용이하고 SOLID 원칙을 쉽게 적용할 수 있는 등 장점이 많아 헥사고날 아키텍처를 적용하였습니다.```




# 핵심 기능

## OAuth2 소셜 로그인
![dddd](https://user-images.githubusercontent.com/96284736/177117919-f8bfda71-3dc3-4d8a-9d14-97cee6a7419d.PNG)

![ddsda](https://user-images.githubusercontent.com/96284736/177117932-7a2b073d-689c-4aff-b873-879f190402a8.PNG)

![222222](https://user-images.githubusercontent.com/96284736/177118328-d9453773-4556-4a9d-9eb2-28cc04083ab7.PNG)

``` 소셜 로그인을 구현하기위해 스프링시큐리티와 OAuth2를 사용하였습니다.로그인을 하지않으면 글이 등록되지않게 시큐리티의 인가기능으로  로그인된 회원만 글쓰기 권한을 주었습니다.```

## validation
![vali1](https://user-images.githubusercontent.com/96284736/177123414-5d69066c-b1bb-4dc0-9798-da980709a0e1.PNG)
![vali2](https://user-images.githubusercontent.com/96284736/177123421-cb6dbcd7-b026-4a70-8169-37dccd859909.PNG)


```articleForm을 만들어 먼저 view로 폼을 보내서 입력값을 받아 @Validated 로 validation을 적용.글의 내용과 제목을 다 적지않으면 글이 등록되지않으며 각각 제목을 적어주세요,내용을  오류메세지와함께 다시 작성폼으로 돌아온다.  ```


## CRUD
### 글등록
![1p](https://user-images.githubusercontent.com/96284736/177152969-b177ce42-365c-45bc-8529-4c185846e29a.PNG)
```게시글 1페이지```
![2p](https://user-images.githubusercontent.com/96284736/177152976-6c0c1fba-e31f-4cfc-81eb-9d8075f19d5a.PNG)
```게시글 2페이지-글쓰기폼에서 validation을 거치면 글이 등록되는데 최신순 10개씩 페이지가 나뉘어 10개가 넘어 페이지가 2페이지로 넘어갔다.jpa 페이징기능을 사용하여 구현하였다.제목과 구글닉네임+#providerId를 작성자로 작성일(jpa Auditing으로 구현),추천수를 table로 보여준다.글 내용은 클릭하면 상세페이지에서 보인다.```
![게시판~](https://user-images.githubusercontent.com/96284736/177153177-59eee828-7906-4dd1-9034-1a1551b321e0.PNG)
```게시글을 클릭하면 나오는 게시글 상세 페이지 ```
### 글수정
![new](https://user-images.githubusercontent.com/96284736/177153407-665aa189-32ca-4d18-bac0-6ef263884a72.PNG)


``` 내 글 수정/삭제를 누르면 로그인된 아이디로 쓴 글만 게시판별로 나누어서 보여줍니다. ```


![수정~~](https://user-images.githubusercontent.com/96284736/177154490-762396a5-436c-4054-9520-2176380cc3f3.PNG)


``` 수정 버튼을 누르면 작성했던 글을 수정할 수 있습니다.```


![수정함2](https://user-images.githubusercontent.com/96284736/177154506-f4b46468-fb6e-44a1-9674-29921cf707bb.PNG)
![수정함3](https://user-images.githubusercontent.com/96284736/177154540-0bb2ab6f-4f9c-475e-a3eb-c874a9aad430.PNG)



``` 수정 버튼을 눌러 수정한 이미지. 코드로는 service에서 변경감지를 사용해서 Article article = articleRepositoryPort.findById(articleId).orElseThrow();-article객체를 repositorty에서 꺼낸다음 article에 수정 메소드를 만든뒤 article.edit(articleDtoCardBox.getContent(),articleDtoCardBox.getTitle()); -article의 필드값을 변경하고 자동으로 transaction메소드가 끝나면 변경감지로 자동으로 수정되게한다. ```


### 글삭제
![삭제함1](https://user-images.githubusercontent.com/96284736/177154769-57db37f5-25ce-4269-8cd4-4fc1d90d6fd9.PNG)
![삭제함2](https://user-images.githubusercontent.com/96284736/177154777-6c556a5f-754a-40d8-90a8-5ebfbb47981b.PNG)



``` 삭제 버튼을 눌러 삭제한 이미지.코드로는 jpaRepository에서 articleRepository.deleteById(id) 메소드로 articleId로 삭제 ```


## 검색
![검색함](https://user-images.githubusercontent.com/96284736/177154955-63e6cd20-7890-4cbb-aad6-15a454f40ef1.PNG)
![검색함2](https://user-images.githubusercontent.com/96284736/177154958-4c1ae32b-cc7a-43fc-ad7c-03bd1237cdf3.PNG)


``` 쿼리 메소드 @Query 어노테이션을 사용 like %:??% 를 써서 제목과 내용으로 검색되게 만들었습니다. ```


## 최신글보기
![최신순글](https://user-images.githubusercontent.com/96284736/177155177-fae61f5e-61ff-45ed-8dac-35ea9ac1385f.PNG)


``` 메소드 이름으로 자동으로 쿼리를 생성하는 jpa의 기능으로 List<Article>findTop5ByOrderByIdDesc() 메소드를 만들어 등록된 게시글중 최근 5개의 게시글을 제목과 작성일로 게시판별로 보여줍니다.클릭하여 게시글내용을 볼수있는 페이지로 이동.```


# 프로젝트 후기

교육 과정에서 나머지분은 팀프로젝트를 하였지만 저는 개인으로 해서 고생을 많이했습니다.</br>(프로젝트하기 한달전만해도 jpa와 시큐리티를 몰라서 한달동안 두개를 계속공부하면서 프로젝트를 하였습니다..)</br>그럼에도 혼자 프로젝트를 진행한 이유는 수업 과정에 포함되지않은 jpa나 security 등 공부해보고 싶은것들을 공부했는데 그러다보니 함께 팀프로젝트를 하기에는 무리가 있다고 판단하여 힘들더라도 혼자 진행하였습니다.</br>jpa를 공부하는데 시간을 많이쓰고 처음 프로젝트에 써보는데 공부할때는 못느꼈던 jpa의 좋은점들을 쓰면서 많이느꼈습니다.시큐리티또한(시큐리티는 아직 능숙하게 쓰려면 더 시간을 써야하지만)프로젝트를 하면서 공부해서 외울수 있는것은 외우려고 노력하면서 프로젝트를 진행했는데 처음 공부할때는 이게 돌아가게 만들수나 있나..라는 생각과 벽을 느꼈지만 하면서 점점 눈에 익어서 구현에 성공하였습니다.</br>프로젝트를 하면서 혼자한걸 절대 후회하지 않을 정도로 얻은것이 많고 오히려 팀으로 했으면 하는 일도 나누다보니 프론트엔드쪽이나 아니면 jpa같은 저만 할줄 아는것은 쓰지 못했을 거라고 생각합니다.

