package demo.lina.shutupandtakemymoney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import demo.lina.shutupandtakemymoney.data.Record
import demo.lina.shutupandtakemymoney.ui.theme.ShutUpAndTakeMyMoneyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShutUpAndTakeMyMoneyTheme {
                MainPage(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MainPage(modifier: Modifier = Modifier) {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        // rememberSaveable: can save the state while activity restart
        // var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
        val recordList = mutableListOf<Record>(
            Record("早餐", 50, "食物"),
            Record("便當", 100, "食物"),
            Record("晚餐", 65, "食物"),
            Record("餅乾", 135, "食物"),
            Record("手搖", 55, "食物"),
            Record("洗衣網", 198, "日用品"),
            Record("棉條", 505, "日用品"),
            Record("排球場地費", 150, "運動"),
            Record("溜冰", 350, "娛樂"),
        )

        ShowRecordList(recordList)
    }
}

@Composable
private fun ShowRecordList(recordList: MutableList<Record>,
                           modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = recordList) { record ->
            ShowRecord(record = record)
        }
    }
}

@Composable
private fun ShowRecord(record: Record, modifier: Modifier = Modifier) {

    Row(
        modifier = modifier.fillMaxWidth().padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = record.name,
            fontSize = 24.sp,
            modifier = Modifier.padding(10.dp)
        )

        Text(
            text = record.amount.toString(),
            fontSize = 24.sp,
            modifier = Modifier.padding(10 .dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ShutUpAndTakeMyMoneyTheme {
        val recordList = mutableListOf(
            Record("早餐", 50, "食物"),
            Record("便當", 100, "食物"),
            Record("晚餐", 65, "食物"),
            Record("餅乾", 135, "食物"),
            Record("手搖", 55, "食物"),
            Record("洗衣網", 198, "日用品"),
            Record("棉條", 505, "日用品"),
            Record("排球場地費", 150, "運動"),
            Record("溜冰", 350, "娛樂"),
        )
        ShowRecordList(recordList)
    }
}