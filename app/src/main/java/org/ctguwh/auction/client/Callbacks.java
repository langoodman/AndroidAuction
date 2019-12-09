package org.ctguwh.auction.client;

import android.os.Bundle;

/**
 * 接口回调
 * 在A类中定义了一个方法，这个方法中用到了一个接口和该接口中的抽象方法，但是抽象方法没有具体的实现，
 * 需要B类去实现，B类实现该方法后，它本身不会去调用该方法，而是传递给A类，供A类去调用
 * 回调其实是一种双向调用模式，也就说调用方在接口被调用时也会调用对方的接口，实现方法交还给提供接口的父类处理！
 * 通过暴露接口方法可以减少很多重复，代码更加优雅。
 * eg：do what 接口  B类 拧螺丝 C类 焊接 A类需要调用do what 由BC类实现以后传递给A类 表示 具体是do what
 */
public interface Callbacks
{
	void onItemSelected(Integer id, Bundle bundle);
}