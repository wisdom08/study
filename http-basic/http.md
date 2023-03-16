# HTTP
HyperText Transfer Protocol

## HTTP 특징
- 클라이언트 서버 구조
- 무상태 프로토콜(stateless), 비연결성
- HTTP 메시지
- 단순함, 확장 가능

### 클라이언트 서버 구조
- Request Response 구조
- 클라이언트는 서버에 요청을 보내고, 응답을 대기
- 서버가 요청에 대한 결과를 만들어서 응답

### 무상태 프로토콜
- 서버가 클라이언트의 상태를 보존X
- 장점
  - 서버 확장성 높음(스케일 아웃, 수평 확장 유리)
    - 응답 서버를 쉽게 바꿀 수 있다 -> 무한한 서버 증설 가능
- 단점
  - 클라이언트가 추가 데이터 전송

### 상태 유지 - Stateful
- 항상 같은 서버가 유지되어야 한다

### 무상태 - Stateless
- 아무 서버나 호출해도 된다.
- 실무에서의 한계
  - 모든 것을 무상태로 설계할 수 있는 경우도 있고 없는 경우도 있다. 
    - 무상태: 로그인이 필요없는 단순한 서비스 소개 화면
    - 상태 유지: 로그인
      - 로그인한 사용자의 경우 로그인 했다는 상태를 서버에 유지
      - 일반적으로 브라우저 쿠키와 서버 세션 등을 사용해서 상태 유지
      - 상태 유지는 최소한만 사용

### 비연결성(connectionless)
- HTTP는 기본이 연결을 유지하지 않는 모델
- 일반적으로 초 단위 이하의 빠른 속도로 응답
- 1시간 동안 수천명이 서비스를 사용해도 실제 서버에서 동시에 처리하는 요청을 수십개 이하로 매우 작음
  - ex) 웹 브라우저에서 계속 연속해서 검색 버튼을 누르지 않는다.
- 서버 자원을 매우 효율적으로 사용할 수 있음

## HTTP 메시지

### 요청 메시지의 시작 라인 구성
> GET / search?q=weather HTTP/1.1
    Host: www.google.com
- HTTP 메서드
- 요청 대상(search?q=weather)
- HTTP Version

### 응답 메시지의 시작 라인 구성
> HTTP/1.1 200 OK
- HTTP 버전
- HTTP 상태 코드
  - 200: 성공
  - 400: 클라이언트 요청 오류
  - 500: 서버 내부 오류
- 이유 문구: 사람이 이해할 수 있는 짧은 상태 코드 설명 글

### HTTP 헤더
- HTTP 전송에 필요한 모든 부가 정보
  - ex) 메시지 바디의 내용, 메시지 바디의 크기, 압축, 인증, 요청 클라이언트(브라우저) 정보, 서버 애플리케이션 정보, 캐시 관리 정보...
- 표준 헤더가 너무 많음
- 필요 시 임의의 헤더 추가 가능

### HTTP 메시지 바디
- 실제 전송할 데이터
- HTML 문서, 이미지, 영상, JSON 등등 byte 로 표현할 수 있는 모든 데이터 전송 가능