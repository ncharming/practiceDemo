package ArrayListAll;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author :nihongyu
 * @Description:
 * @Date:Created in 2020/12/2 0002.
 * @Modified By:
 */

public class RemoveList {
	public static void main(String[] args) {
		//在遍历过程中对list操作会出现问题
//		strongerFor();

		//普通for循环，删除不会报错，但是结果不是我们想要的
		simpleFor();

		//iterator 循环删除
		iteratorFor();

	}


	//删除报错测试
	public static void strongerFor(){
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		for (String s : list) {
			if (s == "2") {       // tips：当 s=="3" ，会成功删除元素
				// 当等于 list 中其他三个元素时都会报错：ConcurrentModificationException
				list.remove("2");
			}
		}
		System.out.println("before:" + list);


//在操作后 break：马上跳出循环，则不会报错
//		for (String s:list) {
//			if(s=="2"){
//				list.remove("2");
//				break;
//			}
//		}
	}

	public static void simpleFor() {
		List<String> list=new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");

//		for(int i=0;i<list.size();i++){
//			if(i%3==0){
//				list.remove(i);
//			}
//		}

		//逆向的 for 循环可以消除元素移动的影响，打印正常（原来数据为0,4,7的三个数被正常删除）
		for(int i=list.size()-1;i>=0;i--){
		    if(i%3==0){
		        list.remove(i);
		    }
		}
		System.out.println("after:"+list);
	}

	public static void iteratorFor(){
		List<String> list = new ArrayList<String>();
		list.add("1");  //
		list.add("2");
		list.add("3");
		list.add("4");  //
		list.add("5");
		list.add("6");
		list.add("7");  //
		list.add("8");

		Iterator<String> iterator=list.iterator();
		while (iterator.hasNext()){
			String s=iterator.next();
			System.out.println(s);
			if((Integer.parseInt(s)-1)%3==0){   //这里数据特殊 Integer.parseInt(s)-1 取的就是 list 的下标
				iterator.remove();  //***
				//list.remove(s);  这里要使用 Iterator的remove 方法移除当前对象，
				// 如果使用 List 的 remove 方法，则同样会出现 ConcurrentModificationException
			}
		}
		System.out.println("after:"+list);
	}


}
