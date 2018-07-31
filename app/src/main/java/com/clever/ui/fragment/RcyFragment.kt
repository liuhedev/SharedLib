package com.clever.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log.println
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.clever.R
import com.clever.ui.adapter.RecyclerViewHeader
import com.cleverlib.utils.SimpleToast

import java.util.ArrayList

class RcyFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_rcy_parent, null)
        initView(view)
        initData()

        return view
    }

    private fun initData() {
        SimpleToast.show(activity, "splash")

    }

    private fun initView(view: View) {
        val parentRcy = view.findViewById<View>(R.id.rcy_rcy_parent) as RecyclerView
        val header = view.findViewById<View>(R.id.recycler_header) as RecyclerViewHeader
        val headerRcy = view.findViewById<View>(R.id.rcy_task_child) as RecyclerView
        val lisener :View.OnClickListener = View.OnClickListener { System.out.println("dd") }
        
        parentRcy.setOnClickListener {System.out.println("dd") }
        //        parentRcy.setLayoutManager(new LinearLayoutManager(getActivity()));
        //        headerRcy.setLayoutManager(new LinearLayoutManager(getActivity()));
        //        ContentAdapter contentAdapter = new ContentAdapter(getActivity(), getTestData("content", 30));
        //        HeaderAdapter headerAdapter = new HeaderAdapter(getActivity(), getTestData("header", 4));
        //        headerRcy.setAdapter(headerAdapter);
        //        parentRcy.setAdapter(contentAdapter);
        //
        //        header.attachTo(parentRcy);

    }

    internal fun getTestData(where: String, count: Int): ArrayList<String> {
        val strings = ArrayList<String>()
        for (i in 0 until count) {
            strings.add(where + "->测试数据->" + i)
        }
        return strings
    }
}
