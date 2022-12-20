package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_logins0 implements _callable{

public static PrintWriter pw; 
public static _cls_logins0 root;

public static LinkedHashMap<_cls_logins0,_cls_logins0> _cls_logins0_instances = new LinkedHashMap<_cls_logins0,_cls_logins0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\abdil\\workspace\\softwaretesting2.2/src/output_logins.txt");

root = new _cls_logins0();
_cls_logins0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_logins0 parent; //to remain null - this class does not have a parent!
public static boolean views;
int no_automata = 1;
 public int badLogins =0 ;
 public int goodLogins =0 ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_logins0() {
}

public void initialisation() {
}

public static _cls_logins0 _get_cls_logins0_inst() { synchronized(_cls_logins0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_logins0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_logins0_instances){
_performLogic_MarketAlertUMProperty(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_logins0[] a = new _cls_logins0[1];
synchronized(_cls_logins0_instances){
a = _cls_logins0_instances.keySet().toArray(a);}
for (_cls_logins0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_logins0_instances){
_cls_logins0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_MarketAlertUMProperty = 14;

public void _performLogic_MarketAlertUMProperty(String _info, int... _event) {

_cls_logins0.pw.println("[MarketAlertUMProperty]AUTOMATON::> MarketAlertUMProperty("+") STATE::>"+ _string_MarketAlertUMProperty(_state_id_MarketAlertUMProperty, 0));
_cls_logins0.pw.flush();

if (0==1){}
else if (_state_id_MarketAlertUMProperty==14){
		if (1==0){}
		else if ((_occurredEvent(_event,34/*badLogin*/))){
		badLogins ++;
_cls_logins0.pw .println ("Bad login observed. Bad logins: "+badLogins );

		_state_id_MarketAlertUMProperty = 14;//moving to state MarketAlertUM
		_goto_MarketAlertUMProperty(_info);
		}
		else if ((_occurredEvent(_event,36/*goodLogin*/))){
		goodLogins ++;
_cls_logins0.pw .println ("Good login observed. Good logins: "+goodLogins );

		_state_id_MarketAlertUMProperty = 12;//moving to state Login
		_goto_MarketAlertUMProperty(_info);
		}
}
else if (_state_id_MarketAlertUMProperty==12){
		if (1==0){}
		else if ((_occurredEvent(_event,38/*view*/)) && (views ==true )){
		goodLogins =0 ;
_cls_logins0.pw .println ("Viewing alerts ... "+views );

		_state_id_MarketAlertUMProperty = 13;//moving to state Alerts
		_goto_MarketAlertUMProperty(_info);
		}
}
else if (_state_id_MarketAlertUMProperty==13){
		if (1==0){}
		else if ((_occurredEvent(_event,40/*logout*/))){
		badLogins =0 ;
_cls_logins0.pw .println ("Logged Out!");

		_state_id_MarketAlertUMProperty = 14;//moving to state MarketAlertUM
		_goto_MarketAlertUMProperty(_info);
		}
}
}

public void _goto_MarketAlertUMProperty(String _info){
_cls_logins0.pw.println("[MarketAlertUMProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_MarketAlertUMProperty(_state_id_MarketAlertUMProperty, 1));
_cls_logins0.pw.flush();
}

public String _string_MarketAlertUMProperty(int _state_id, int _mode){
switch(_state_id){
case 14: if (_mode == 0) return "MarketAlertUM"; else return "MarketAlertUM";
case 12: if (_mode == 0) return "Login"; else return "Login";
case 13: if (_mode == 0) return "Alerts"; else return "Alerts";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}