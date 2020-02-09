 create or replace procedure P_AUTH
  2  (
  3  uname IN VARCHAR2,
  4  pwd IN VARCHAR2,
  5  result OUT VARCHAR2
  6  )
  7  as
  8  cnt NUMBER;
  9  begin
 10  SELECT COUNT(*) INTO cnt FROM USERLIST WHERE UNAME=uname AND PASSWORD=pwd;
 11  if(cnt<>0) then
 12   result:='registration success';
 13  else
 14    result:='registration fail';
 15  end if;
 16* end;
 17  /