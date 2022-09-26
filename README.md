
# Android GPLApplication
가평이씨\r\n
묘소 위치를 출력하느 어플
아버지요청으로 학습하며 개발
마켓주소

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

