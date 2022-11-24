package com.zipper.navigationtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_main.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMain : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val buttonNavigationHost = view.findViewById<Button>(R.id.btn_navigate_to_focusable)
        val buttonSupportFragment = view.findViewById<Button>(R.id.btn_navigate_to_non_focusable)
        buttonNavigationHost.setOnClickListener{Navigation.findNavController(view).navigate(R.id.action_fragmentMain_to_fragment_focusable2)}

        buttonSupportFragment.setOnClickListener{
            this.activity?.supportFragmentManager
                ?.beginTransaction()
                ?.add(R.id.main_content_view, FragmentFocusTest())
                ?.addToBackStack(FragmentFocusTest.javaClass.name)
                ?.commit()
        }
        return view
    }


}