package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_scraper0 implements _callable{

public static PrintWriter pw; 
public static _cls_scraper0 root;

public static LinkedHashMap<_cls_scraper0,_cls_scraper0> _cls_scraper0_instances = new LinkedHashMap<_cls_scraper0,_cls_scraper0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\abdil\\workspace\\softwaretesting2.2/src/output_scraper.txt");

root = new _cls_scraper0();
_cls_scraper0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_scraper0 parent; //to remain null - this class does not have a parent!
public static boolean request;
public static boolean response;
public static boolean returning;
int no_automata = 1;
 public int goodAPI =0 ;
 public int badAPI =0 ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_scraper0() {
}

public void initialisation() {
}

public static _cls_scraper0 _get_cls_scraper0_inst() { synchronized(_cls_scraper0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_scraper0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_scraper0_instances){
_performLogic_eBayProperty(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_scraper0[] a = new _cls_scraper0[1];
synchronized(_cls_scraper0_instances){
a = _cls_scraper0_instances.keySet().toArray(a);}
for (_cls_scraper0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_scraper0_instances){
_cls_scraper0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_eBayProperty = 2;

public void _performLogic_eBayProperty(String _info, int... _event) {

_cls_scraper0.pw.println("[eBayProperty]AUTOMATON::> eBayProperty("+") STATE::>"+ _string_eBayProperty(_state_id_eBayProperty, 0));
_cls_scraper0.pw.flush();

if (0==1){}
else if (_state_id_eBayProperty==1){
		if (1==0){}
		else if ((_occurredEvent(_event,0/*getResponse*/)) && (response ==true )){
		;
_cls_scraper0.pw .println ("Getting Response");

		_state_id_eBayProperty = 2;//moving to state eBay
		_goto_eBayProperty(_info);
		}
}
else if (_state_id_eBayProperty==0){
		if (1==0){}
		else if ((_occurredEvent(_event,2/*returnTo*/)) && (returning ==true )){
		badAPI =0 ;
_cls_scraper0.pw .println ("Returning to scraper ... "+returning );

		_state_id_eBayProperty = 2;//moving to state eBay
		_goto_eBayProperty(_info);
		}
}
else if (_state_id_eBayProperty==2){
		if (1==0){}
		else if ((_occurredEvent(_event,4/*goodRequest*/)) && (request ==true )){
		goodAPI ++;
_cls_scraper0.pw .println ("Good API request: "+goodAPI );

		_state_id_eBayProperty = 1;//moving to state MarketAlertUM
		_goto_eBayProperty(_info);
		}
		else if ((_occurredEvent(_event,6/*badRequest*/)) && (request ==true )){
		badAPI ++;
_cls_scraper0.pw .println ("Bad request observed. Bad requests: "+badAPI );

		_state_id_eBayProperty = 0;//moving to state BadState
		_goto_eBayProperty(_info);
		}
}
}

public void _goto_eBayProperty(String _info){
_cls_scraper0.pw.println("[eBayProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_eBayProperty(_state_id_eBayProperty, 1));
_cls_scraper0.pw.flush();
}

public String _string_eBayProperty(int _state_id, int _mode){
switch(_state_id){
case 1: if (_mode == 0) return "MarketAlertUM"; else return "MarketAlertUM";
case 0: if (_mode == 0) return "BadState"; else return "!!!SYSTEM REACHED BAD STATE!!! BadState "+new _BadStateExceptionscraper().toString()+" ";
case 2: if (_mode == 0) return "eBay"; else return "eBay";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}