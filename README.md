# 일상에서구조
### 프로젝트 수행 기간
> 2023/01/06 ~ 2023/02/16
### [시연 영상(Youtub)](https://www.youtube.com/watch?v=InxgLKkO7dY)

## 1. 프로젝트 주제
+ API(지도, 맛집, 축제, 관광지)를 활용하여 사용자에게 여행정보를 제공하고 사용자의 평가와 데이터를 담아 다양한 여행정보를 찾아준다.

![main](https://user-images.githubusercontent.com/117332854/218946416-f6879688-4070-4743-958a-ec42c725d8a7.png)

## 2. 프로젝트 목적과 기능
+ 전국의 관광지, 맛집, 축제등의 정보를 제공하여 사용자가 직접 일정을 짤수 있으며, 커뮤니티로 여행 정보 교환을 할수있는 웹사이트를 개발
+ 회원가입 페이지에 ajax를 이용한 유효성검사와 이메일 인증(smtp) 기능 구현
+ API(카카오맵, 공공데이터포털)를 활용하여 사용자들에게 맛집,축제,관광지 정보를 제공하는 기능 구현
+ 사용자들간에 여행정보를 공유할 수 있는 커뮤니티 구현
+ fullcalendar를 활용하여 마이페이지에 사용자가 일정을 세울수있는 기능 구현
+ 여행상세페이지에 찜기능을 추가하여 위시리스트에 여행지정보를 담을수있는 기능 구현
+ 관리자페이지와 사용자페이지의 적절한 연동으로 사용자에게 추천 코스를 제공하는 기능 구현
+ 네이버 클라우드 플랫폼에서 제공하는 Chatbot을 활용하여 사용자의 편의를 제공
## 3. 시스템구성도 / 개발 도구
✨ **시스템 구성도**

![시스템 구성도](https://user-images.githubusercontent.com/117332854/218950415-1120a874-3d35-40c1-9d2b-f50fd0af9c46.png)

✨ **개발 도구**

![수행 도구](https://user-images.githubusercontent.com/117332854/218965156-b3ba51c9-3a5f-4e67-a003-4296a5c3a1ef.png)

## 4. DB 설계

![erd](https://user-images.githubusercontent.com/117332854/218951391-63c2dfa1-11ef-4b54-90aa-5736d680e81a.png)

## 5. 화면 설계

![image](https://user-images.githubusercontent.com/117332854/218951877-dc0a07cf-675c-4a54-9d01-2296603ee9f9.png)

## 6. 프로젝트 구성원 및 역할

![역할](https://user-images.githubusercontent.com/117332854/218985220-4842a6cf-fc2f-44fc-b7e3-edb54d74160e.png)

## 8. 웹 화면
✨ ** 사용자 **
+ 메인 페이지

![메인페이지](https://user-images.githubusercontent.com/117332854/219245458-782c79c1-c84c-4e27-8c2d-44c61cbdf8c4.gif)
  
    이달의여행지슬라이드와 추천코스를 보여준다.
  
+ 회원가입 페이지

![회원가입페이지](https://user-images.githubusercontent.com/117332854/219245151-a14e3f57-c37c-4aab-83d4-d6f42bb37806.gif)
  
    유효성검사와 이메일인증 기능을 추가하여 회원가입을 진행하였다.
  
+ 로그인 페이지

![로그인페이지](https://user-images.githubusercontent.com/117332854/219245631-ca00c208-951e-4291-a9b1-e2f088f9e0b8.gif)

+ 회정보수정 페이지

![회원정보수정페이지](https://user-images.githubusercontent.com/117332854/219245531-d242e9d5-8fc3-4c76-b02d-d8c331c589e2.gif)

+ 추천 코스 페이지
  
![추천코스페이지](https://user-images.githubusercontent.com/117332854/219245666-6c1d75fb-d537-4b6c-8f00-48364d2d7d3e.gif)
  
    관리자의 추천코스정보를 보여준다.
  
+ 공지사항 페이지

![공지사항페이지](https://user-images.githubusercontent.com/117332854/219245673-f390e239-6f81-4a79-b831-dbc37dab1cf4.gif)

+ 여행소개 페이지

![여행소개페이지](https://user-images.githubusercontent.com/117332854/219245653-453c3a89-fd79-4ba5-b3b8-a68247698826.gif)

![여행소개상세페이지](https://user-images.githubusercontent.com/117332854/219245649-42080e15-f3d0-4222-a831-65f3d3735368.gif)
  
    카카오맵api를 활용하여 여행지를 마킹하여 보여주고 좋아요기능과 찜기능을 추가하여 원하는 여행지를 위시리스트로 보낼수 있다.

+ 일정 페이지

![일정페이지](https://user-images.githubusercontent.com/117332854/219245663-b5784e05-f82e-4f9d-bb1a-dfb66397173d.gif)

+ 위시리스트 페이지

![위시리스트](https://user-images.githubusercontent.com/117332854/219245657-ae85c61d-9c5d-4032-af4c-717e8460abee.gif)

+ 게시판 페이지

![게시판페이지](https://user-images.githubusercontent.com/117332854/219245669-9aee86e0-bd8a-45dd-8355-f3927ab54485.gif)
  
    사용자들간의 여행정보를 교환할수있는 커뮤니티
    
+ 1:1문의 페이지

![1대1문의페이지](https://user-images.githubusercontent.com/117332854/219247420-920ff295-fd7f-4fee-9b0b-3bc895aa648f.gif)
  
    1대1문의의 답변은 관리자페이지에서 확인하여 이메일로 답변을 보낸준다.
  
+ 챗봇

![챗봇](https://user-images.githubusercontent.com/117332854/219247425-9a22477c-3a44-4312-bba0-439ee9b21f4e.gif)
  
   사용자의 간단한 문의를 처리할수있다.


✨ ** 관리자 **

+ Dashboard

![대시보드](https://user-images.githubusercontent.com/117332854/219251600-847facc0-6a2c-4099-bf4e-0a36a7b23691.gif)

    회원수, 운영진현황, 인기게시물, 인기여행정보, 통계등을 보여준다.

+ 추천코스관리 페이지

![추천코스관리](https://user-images.githubusercontent.com/117332854/219251602-46e0c7fd-af3d-4b28-822e-0b64a1deabf5.gif)

    관리자가 추천코스를 만들어 사용자페이지로 보낼수 있다.

+ 관리자정보관리 페이지

![관리자정보관리](https://user-images.githubusercontent.com/117332854/219251598-b986509d-e95a-40df-bc92-f2293f51724a.gif)

    관리자레벨에따라 접근권한이 달라진다.

+ 회원정보관리 페이지

![회원정보관리](https://user-images.githubusercontent.com/117332854/219251604-3c0886f7-012c-4b70-8de1-faf4952a5f41.gif)

+ 게시판관리 페이지

![관리자게시판관리](https://user-images.githubusercontent.com/117332854/219251593-cc2ebc3e-3c0c-43af-a688-1b1add5d8b49.gif)

+ 1:1문의관리 페이지

![1대1문의관리](https://user-images.githubusercontent.com/117332854/219251606-d69589bb-026a-4988-a037-2959e06a1166.gif)

## 9. 트러블 슈팅

![trouble](https://user-images.githubusercontent.com/117332854/219039047-6c1c36e9-2b10-490b-912c-78f802b06266.png)


