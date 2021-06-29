package com.zuri.kidvacc_mobile_pjt_37.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.zuri.kidvacc_mobile_pjt_37.R
import com.zuri.kidvacc_mobile_pjt_37.ui.add_a_child.Add_A_Child
import com.zuri.kidvacc_mobile_pjt_37.ui.infobase.Info_Base_Fragment
import com.zuri.kidvacc_mobile_pjt_37.ui.vaccines.VaccineFragment

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        //val frameLayout: FrameLayout = root.findViewById(R.id.frameLayout)

        /*val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

        root.findViewById<View>(R.id.relativeLayout).setOnClickListener {
            val fm: FragmentManager? = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fm!!.beginTransaction()
            fragmentTransaction.replace(R.id.home_frameLayout, Add_A_Child())
            fragmentTransaction.setReorderingAllowed(true)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        root.findViewById<View>(R.id.infobase).setOnClickListener {
            val fm: FragmentManager? = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fm!!.beginTransaction()
            fragmentTransaction.replace(R.id.home_frameLayout, Info_Base_Fragment())
            fragmentTransaction.setReorderingAllowed(true)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        root.findViewById<View>(R.id.vaccines).setOnClickListener {
            val fm: FragmentManager? = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fm!!.beginTransaction()
            fragmentTransaction.replace(R.id.home_frameLayout, VaccineFragment())
            fragmentTransaction.setReorderingAllowed(true)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        return root
    }
}