package aspects;

import larva.*;
public aspect _asp_logins0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_logins0.initialize();
}
}
before ( boolean views) : (call(* *.view(..)) && args(views) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_logins0.lock){

_cls_logins0 _cls_inst = _cls_logins0._get_cls_logins0_inst();
_cls_inst.views = views;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 38/*view*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 38/*view*/);
}
}
before () : (call(* *.goodLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_logins0.lock){

_cls_logins0 _cls_inst = _cls_logins0._get_cls_logins0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 36/*goodLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 36/*goodLogin*/);
}
}
before () : (call(* *.badLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_logins0.lock){

_cls_logins0 _cls_inst = _cls_logins0._get_cls_logins0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 34/*badLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 34/*badLogin*/);
}
}
before () : (call(* *.logout(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_logins0.lock){

_cls_logins0 _cls_inst = _cls_logins0._get_cls_logins0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 40/*logout*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 40/*logout*/);
}
}
}