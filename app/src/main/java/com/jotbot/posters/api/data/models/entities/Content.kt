package com.jotbot.posters.api.data.models.entities


import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.util.DisplayMetrics
import android.view.Display
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.jotbot.posters.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.gson.annotations.SerializedName
import kotlin.math.floor

data class Content(
    @SerializedName("agvotCode")
    val agvotCode: String,
    @SerializedName("alias")
    val alias: Alias,
    @SerializedName("availability")
    val availability: String,
    @SerializedName("axisCustomContentsCount")
    val axisCustomContentsCount: Int,
    @SerializedName("axisId")
    val axisId: Int,
    @SerializedName("axisMainContentsCount")
    val axisMainContentsCount: Int,
    @SerializedName("axisPromoContentsCount")
    val axisPromoContentsCount: Int,
    @SerializedName("defaultLangCode")
    val defaultLangCode: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("featuredClip")
    val featuredClip: Any?,
    @SerializedName("featuredEpisode")
    val featuredEpisode: Any?,
    @SerializedName("firstAirYear")
    val firstAirYear: String?,
    @SerializedName("flagLabel")
    val flagLabel: Any?,
    @SerializedName("flagTitle")
    val flagTitle: Any?,
    @SerializedName("flagVisibility")
    val flagVisibility: Boolean,
    @SerializedName("heroBrandLogoId")
    val heroBrandLogoId: String,
    @SerializedName("images")
    val images: Images,
    @SerializedName("mediaType")
    val mediaType: String,
    @SerializedName("originatingNetwork")
    val originatingNetwork: Any?,
    @SerializedName("originatingNetworkImages")
    val originatingNetworkImages: OriginatingNetworkImages,
    @SerializedName("originatingNetworkLogoId")
    val originatingNetworkLogoId: Any?,
    @SerializedName("resourceCodes")
    val resourceCodes: List<String>,
    @SerializedName("scheduleEndDate")
    val scheduleEndDate: String,
    @SerializedName("scheduleStartDate")
    val scheduleStartDate: String,
    @SerializedName("seasons")
    val seasons: List<Season>,
    @SerializedName("seasonsCount")
    val seasonsCount: Int,
    @SerializedName("subscriptionPackages")
    val subscriptionPackages: List<String>,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
) {
    companion object {
        @BindingAdapter("android:onClick")
        @JvmStatic
        fun setOnClick(view: View, poster: Content) {
            view.setOnClickListener {
                val builder = AlertDialog.Builder(view.context)
                builder.setTitle(poster.title)
                builder.setMessage(poster.summary)
                builder.show()
            }
        }

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, url: String) {
            val width = getPosterWidth(view.context as Activity).toInt()
            val height = getPosterHeight(width)
            val posterUrl = url + "?width=${width}&height=${height}"
            Glide.with(view.context)
                .load(posterUrl)
                .placeholder(R.drawable.ic_image)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .centerCrop()
                .into(view)
        }

        @JvmStatic
        @BindingAdapter("layoutWidth")
        fun setLayoutWidth(view: ImageView, width: Float) {
            var widthImageView = getPosterWidth(view.context as Activity).toInt()
            if (widthImageView == 0)
                widthImageView = width.toInt()
            view.layoutParams.width = widthImageView
        }

        @JvmStatic
        @BindingAdapter("layoutHeight")
        fun setLayoutHeight(view: ImageView, height: Float) {
            val widthImageView = getPosterWidth(view.context as Activity).toInt()
            var heightImageView = getPosterHeight(widthImageView)
            if(heightImageView == 0)
                heightImageView = height.toInt()
            view.layoutParams.height = heightImageView
        }

        /**
         * Method to calculate imageView width which displays poster
         */
        private fun getPosterWidth(activity: Activity): Double {
            activity.getSystemService(Context.WINDOW_SERVICE) as WindowManager

            val outMetrics = DisplayMetrics()
            val display: Display?
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
                display = activity.display
                display?.getRealMetrics(outMetrics)
            } else {
                @Suppress("DEPRECATION")
                display = activity.windowManager.defaultDisplay
                @Suppress("DEPRECATION")
                display.getMetrics(outMetrics)
            }
            val metrics = DisplayMetrics()
            display?.getRealMetrics(metrics)
            val width = metrics.widthPixels
            // Margins applied around the card view
            val margins = convertDpToPixel(50.0f, context = activity)
            // Width of 1 imageView displaying poster
            return floor((width - margins) / (3).toDouble())
        }

        /**
         * This method to calculate imageView height displaying poster
         */
        private fun getPosterHeight(width: Int): Int {
            return (width / 2) * 3
        }

        /**
         * Method converts dp unit to equivalent pixels, depending on device density.
         *
         * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
         * @param context Context to get resources and device specific display metrics
         * @return A float value to represent px equivalent to dp depending on device density
         */
        private fun convertDpToPixel(dp: Float, context: Context): Float {
            return dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
        }
    }

}