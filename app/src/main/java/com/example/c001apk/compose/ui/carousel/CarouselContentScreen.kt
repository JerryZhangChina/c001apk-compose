package com.example.c001apk.compose.ui.carousel

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.c001apk.compose.ui.component.CommonScreen
import com.example.c001apk.compose.util.ReportType

/**
 * Created by bggRGjQaUbCoE on 2024/6/11
 */
@Composable
fun CarouselContentScreen(
    url: String,
    title: String,
    bottomPadding: Dp,
    refreshState: Boolean?,
    resetRefreshState: () -> Unit,
    onViewUser: (String) -> Unit,
    onViewFeed: (String, String?) -> Unit,
    onOpenLink: (String, String?) -> Unit,
    onCopyText: (String?) -> Unit,
    isHomeFeed: Boolean = false,
    onReport: (String, ReportType) -> Unit,
) {

    val viewModel =
        hiltViewModel<CarouselViewModel, CarouselViewModel.ViewModelFactory>(key = title + url) { factory ->
            factory.create(isInit = false, url = url, title = title)
        }

    CommonScreen(
        viewModel = viewModel,
        refreshState = refreshState,
        resetRefreshState = resetRefreshState,
        bottomPadding = bottomPadding,
        onViewUser = onViewUser,
        onViewFeed = onViewFeed,
        onOpenLink = onOpenLink,
        onCopyText = onCopyText,
        isHomeFeed = isHomeFeed,
        onReport = onReport,
    )

}