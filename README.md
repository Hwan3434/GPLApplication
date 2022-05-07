안녕하세요


# Android GPLApplication
가평이씨 Application
기억하지말고 기록으로 남기기위해 어플로 등록
market : google.play.com/detail:~~

## 핵심 데이터구조
#### PersonModel
    이름
    출생년도
    성별
    List<PersonModel> 자식들
    키
    몸무게
      
#### DeadPersonModel : PersonModel
    위도
    경도
    
#### AlivePersonModel : PersonModel
    사는곳
    

## 화면구성 (4개 화면)
    Activity - FragmentManager - Fragment(0~4)
    Naver Map Dispaly (Tab 1)
    RecyclerView List Display (Tab 2)
    Setting Display (Tab 3)
    Person Infomation Display (Non Tab)
    
## 사용기술
  - Kotlin
  - Dagger hilt
  - MVVM Pattern
  - Room Database
  - Databindng
  - Naver Maps Android Api

