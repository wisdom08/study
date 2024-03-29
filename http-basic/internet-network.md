# 인터넷 네트워크
- 인터넷 통신
- IP(Internet Protocol)
- TCP, UDP
- PORT
- DNS

## 인터넷 통신
- 인터넷에서 컴퓨터 둘은 어떻게 통신할까?
  - 만약 클라이언트와 서버가 가까이 있으면 케이블로 연결하여 통신할 수 있다.
  - 거리가 멀면, 인터넷 망을 통해서 메시지를 보내야 한다. 
    - 그런데 인터넷 망은 수많은 노드들로 이루어져있고 복잡하다. 규칙이 필요하다. 

## IP
### IP 역할
- 지정한 IP 주소에 데이터 전달
- 패킷이라는 통신 단위로 데이터 전달

### IP 패킷 정보
- 출발지 IP, 목적지 IP, 기타...

### IP 프로토콜의 한계
- 비연결성
  - 패킷을 받을 대상이 없거나 서비스 불능 상태여도 패킷 전송
- 비신뢰성
  - 중간에 패킷이 사라지면?
  - 패킷이 순서대로 안 오면?
- 프로그램 구분
  - 같은 IP를 사용하는 서버에서 통신하는 애플리케이션이 둘 이상이면?

## TCP
### 인터넷 프로토콜 스택의 4계층
- 애플리케이션 계층: HTTP, FTP
- 전송 계층: TCP, UDP
- 인터넷 계층: IP
- 네트워크 인터페이스 계층

### TCP 패킷 정보
- 출발지 PORT, 목적지 PORT, 전송 제어, 순서, 검증 정보...

### TCP 특징
전송 제어 프로토콜(Transmission Control Protocol)
- 연결 지향
  - TCP 3 way handshake(가상 연결)
- 데이터 전달 보증
- 순서 보장
- 신뢰할 수 있는 프로토콜

### TCP 3 way handshake
>- SYN: 접속 요청 
>- ACK: 요청 수락
1. 클라이언트에서 서버로 SYN
2. 서버에서 클라이언트로 SYN+ACK
3. 클라이언트에서 서버로 ACK
   - ACK 와 함꼐 데이터를 전송하기도 한다.
4. 데이터 전송

## UDP
사용자 데이터그램 프로토콜(User Datagram Protocol)
- 기능이 거의 없어 화면 도화지에 비유하기도 한다. 
- 연결 지향-TCP 3 way handshake X
- 데이터 전달 보증 X
- 순서 보장 X
- 데이터 전달 및 순서가 보장되지 않지만 단순하고 빠름
- 정리
  - UDP는 IP와 거의 같다 + PORT + 체크섬 정도만 추가
  - 애플리케이션에서 추가 작업 필요

## PORT
- 같은 IP 내에서 프로세스 구분
- 0 ~ 65535 할당 가능
- 0 ~ 1023: 잘 알려진 포트, 사용하지 않는 것이 좋음
  - FTP: 20, 21
  - TELNET: 23
  - HTTP: 80
  - HTTPS: 443

## DNS
> IP는 기억하기 어렵고 변경될 수 있다.
- 도메인 네임 시스템(Domain Name System)
- 도메인 명을 IP 주소로 변환

---

### 참고: 프로토콜
- 서로 간에 데이터를 주고 받기위해서 데이터는 이런 모양이어야하고 그 안에 ip, port 라는 게 있어야 한다 등의 약속을 말한다. 
- 인터넷은 실제 byte 데이터를 전달하면서 통신하는데 어떻게 통신할지, 앞의 몇자리는 IP가 들어가고 나머지는 데이터가 들어가는 등 약속이 필요한데, 이것이 프로토콜이다.
