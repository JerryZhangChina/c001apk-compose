package com.example.c001apk.compose.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.view.Gravity
import com.example.c001apk.compose.util.dp


/*
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 */

// mod from https://github.com/klinker24/Android-BadgedImageView
class BadgedImageView(
    context: Context,
) : RoundedImageView(context) {
    private var badgeBoundsSet = false
    private var badge: BadgeDrawable? = null
    private var badgeGravity: Int = Gravity.END or Gravity.BOTTOM
    private var badgePadding: Int = 4.dp
    var colorPrimaryContainer: Int = Color.BLACK
    var colorOnPrimaryContainer: Int = Color.WHITE

    fun setBadge(text: String) {
        badge = BadgeDrawable(text, colorPrimaryContainer, colorOnPrimaryContainer)
        badgeBoundsSet = false
        invalidate()
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        if (badge != null) {
            if (!badgeBoundsSet) {
                layoutBadge()
            }
            badge?.draw(canvas)
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (badge != null) {
            layoutBadge()
        }
    }

    private fun layoutBadge() {
        badge?.let { badge ->
            val badgeBounds = badge.getBounds()
            Gravity.apply(
                badgeGravity,
                badge.intrinsicWidth,
                badge.intrinsicHeight,
                Rect(0, 0, width, height),
                badgePadding,
                badgePadding,
                badgeBounds
            )
            badge.bounds = badgeBounds
            badgeBoundsSet = true
        }

    }
}