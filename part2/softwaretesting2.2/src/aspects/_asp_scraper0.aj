package aspects;

import larva.*;
public aspect _asp_scraper0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_scraper0.initialize();
}
}
before ( boolean response) : (call(* *.getResponse(..)) && args(response) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_scraper0.lock){

_cls_scraper0 _cls_inst = _cls_scraper0._get_cls_scraper0_inst();
_cls_inst.response = response;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 0/*getResponse*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 0/*getResponse*/);
}
}
before ( boolean returning) : (call(* *.returnTo(..)) && args(returning) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_scraper0.lock){

_cls_scraper0 _cls_inst = _cls_scraper0._get_cls_scraper0_inst();
_cls_inst.returning = returning;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 2/*returnTo*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 2/*returnTo*/);
}
}
before ( boolean request) : (call(* *.goodRequest(..)) && args(request) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_scraper0.lock){

_cls_scraper0 _cls_inst = _cls_scraper0._get_cls_scraper0_inst();
_cls_inst.request = request;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 4/*goodRequest*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 4/*goodRequest*/);
}
}
before ( boolean request) : (call(* *.badRequest(..)) && args(request) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_scraper0.lock){

_cls_scraper0 _cls_inst = _cls_scraper0._get_cls_scraper0_inst();
_cls_inst.request = request;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 6/*badRequest*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 6/*badRequest*/);
}
}
}