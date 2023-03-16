# HTTP 헤더1 - 일반 헤더
## HTTP 헤더 용도
- HTTP 전송에 필요한 모든 부가정보
- ex) 메시지 바디의 내용, 메시지 바디의 크기, 압축, 인증, 요청 클라이언트, 서버 정보, 캐시 관리 정보...
- 표준 헤더가 너무 많음
- 필요 시 임의의 헤더 추가 가능

## RFC7230~7235
- 엔티티(Entity) -> 표현(Representation)
- Representation = representation Metadata + Representation Data
- 표현 = 표현 메타데이터 + 표현 데이터

### HTTP BODY
message body - RFC7230(최신)
- 메시지 본문(message body)을 통해 표현 데이터 전달
- 메시지 본문 = 페이로드(payload)
- 표현은 요청이나 응답에서 전달할 실제 데이터
- 표현 헤더는 표현 데이터를 해석할 수 있는 정보 제공
  - 데이터 유형(html, json), 데이터 길이, 압축 정보 등등

### 표현
- Content-Type: 표현 데이터의 형식 
- Content-Encoding: 표현 데이터의 압축 방식 
- Content-Language: 표현 데이터의 자연 언어 
- Content-Length: 표현 데이터의 길이
- 표현 헤더는 전송, 응답 둘다 사용


### 협상(콘텐츠 네고시에이션)
클라이언트가 선호하는 표현 요청
- Accept: 클라이언트가 선호하는 미디어 타입 전달
- Accept-Charset: 클라이언트가 선호하는 문자 인코딩
- Accept-Encoding: 클라이언트가 선호하는 압축 인코딩
- Accept-Language: 클라이언트가 선호하는 자연 언어
- 협상 헤더는 요청시에만 사용

## 쿠키
- Set-Cookie: 서버에서 클라이언트로 쿠키 전달(응답)
- Cookie: 클라이언트가 서버에서 받은 쿠키를 저장하고, HTTP 요청시 서버로 전달
- 사용처
  - 사용자 로그인 세션 관리 
  - 광고 정보 트래킹
- 쿠키 정보는 항상 서버에 전송됨 
  - 네트워크 트래픽 추가 유발 
  - 최소한의 정보만 사용(세션 id, 인증 토큰)
  - 서버에 전송하지 않고, 웹 브라우저 내부에 데이터를 저장하고 싶으면 웹 스토리지 (localStorage, sessionStorage) 참고
- 보안에 민감한 데이터는 저장하면 안됨(주민번호, 신용카드 번호 등등)
```
set-cookie: sessionId=abcde1234; expires=Sat, 26-Dec-2020 00:00:00 GMT; path=/; domain=.google.com; Secure
```

### 쿠키 - 보안
Secure, HttpOnly, SameSite
- Secure
  - 쿠키는 http, https를 구분하지 않고 전송
  - Secure를 적용하면 https인 경우에만 전송 HttpOnly

- HttpOnly
  - XSS 공격 방지
  - 자바스크립트에서 접근 불가(document.cookie)
  - HTTP 전송에만 사용

- SameSite
  - XSRF 공격 방지
  - 요청 도메인과 쿠키에 설정된 도메인이 같은 경우만 쿠키 전송

### Stateless
- HTTP는 무상태(Stateless) 프로토콜이다.
- 클라이언트와 서버가 요청과 응답을 주고 받으면 연결이 끊어진다. 
- 클라이언트가 다시 요청하면 서버는 이전 요청을 기억하지 못한다. 
- 클라이언트와 서버는 서로 상태를 유지하지 않는다.

