package com.hobbyloop.feature.reservation.reservation_detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hobbyloop.feature.reservation.component.section.SectionHeader
import com.hobbyloop.ui.R
import theme.HobbyLoopTypo

@Composable
fun ClassNoticeSection(
    notice: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SectionHeader(
            title = "공지사항",
            iconRes = R.drawable.ic_megaphone_color,
            iconDescription = "공지사항 아이콘",
            textStyle = HobbyLoopTypo.head16
        )

        Text(
            text = notice,
            style = HobbyLoopTypo.body14.copy(lineHeight = 22.sp),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun PreviewClassNoticeSection() {
    Surface {
        ClassNoticeSection(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
                .padding(vertical = 24.dp)
                .padding(horizontal = 16.dp),
            notice = "5월 둘째주는 휴무이니 참고하여 이용에 차질 없으시길 바랍니다."
        )
    }
}
