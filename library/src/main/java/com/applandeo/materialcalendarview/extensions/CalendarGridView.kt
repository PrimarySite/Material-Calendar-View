package com.applandeo.materialcalendarview.extensions

import android.content.Context
import android.util.AttributeSet
import android.widget.GridView

/**
 * Created by Mateusz Kornakiewicz on 15.11.2017.
 */

class CalendarGridView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : GridView(context, attrs, defStyleAttr) {

    //This method is needed to get wrap_content height for GridView
    public override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE shr 2, MeasureSpec.AT_MOST)
        super.onMeasure(widthMeasureSpec, expandSpec)
    }
}
