# URI 와 웹 브라우저 요청 흐름

## URI
Uniform Resource Identifier
- URI 는 로케이터(locator), 이름(name) 또는 둘 다 추가로 분류될 수 있다.
  - URI = URL(Uniform Resource Locator) + URN(Uniform Resource Name ) + ... 

### URI 단어 뜻
- Uniform: 리소스를 식별하는 통일된 방식
- Resource: 자원, URI로 식별할 수 있는 모든 것(제한 없음)
- Identifier: 다른 항목과 구분하는데 필요한 정보

### URL, URN 단어 뜻
- URL - Locator: 리소스가 있는 위치를 지정
- URN - Name: 리소스에 이름을 부여
- 위치는 변할 수 있지만 이름은 변하지 않는다.

### URL 전체 문법
scheme://[userinfo@]host[:port][/path][?query][#fragment]ps
```
https://www.google.com:443/search?q=hello&hl=ko
```
- scheme
  - 주로 프로토콜 사용
- userinfo
  - url에 사용자 정보를 포함해서 인증
  - 거의 사용하지 않음
- host
  - 호스트명
  - 도메인명 또는 IP 주소를 직접 사용 가능
- port
  - 접속 포트
  - 일반적으로 생략
    - http:80 / https:443
- path
  - 리소스 경로, 계층적 구조
- query
  - key=value 형태
  - ?로 시작, &로 추가 가능
  - query parameter, query string 등으로 불림, 웹서버에서 제공하는 파라미터, 문자 형태
- fragment
  - html 내부 북마크 등에 사용
  - 서버에 전송하는 정보가 아님

## 웹 브라우저 요청 흐름
> 웹 브라우저 = 클라이언트  
> 웹 서버 = 서버

1) 웹 브라우저에 입력된 URL 로 부터 IP, PORT 정보를 얻고 웹 브라우저가 HTTP 요청 메시지를 생성한다.
2) 애플리케이션 계층의 소켓 라이브러리를 통해 IP, PORT 정보를 헤더 부분에 담아 연결을 위한 패킷을 만들고 3-way-handshake 로 웹 서버와 연결한다.
3) 소켓 라이브러리를 통해 HTTP 메시지를 TCP/IP 계층으로 전달한다.
4) 헤더 부분(출발지 IP, PORT, 목적지 IP, PORT 등)과 데이터 부분(HTTP 요청 메시지)을 합쳐 TCP/IP 패킷을 생성한다.
5) 웹 브라우저에서 인터넷망(수많은 노드들)을 거쳐 웹 서버로 패킷을 전달한다.
6) 웹 서버는 도착한 패킷의 헤더 부분은 버리고 데이터 부분(HTTP 요청 메시지)를 해석하여 HTTP 응답 메시지를 만든다.
7) 헤더 부분(출발지 IP, PORT, 목적지 IP, PORT 등)과 데이터 부분(HTTP 응답 메시지)을 합쳐 TCP/IP 응답 패킷을 생성한다.
8) 웹 서버에서 인터넷망(수많은 노드들)을 거쳐 웹 브라우저로 응답 패킷을 전달한다.
9) 웹 브라우저는 도착한 응답 패킷의 헤더 부분은 버리고 HTTP 응답 메시지의 데이터(HTML)을 렌더링하여 화면에 뿌려준다.
