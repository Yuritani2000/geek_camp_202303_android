package com.example.geek202303.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.geek202303.R
import com.example.geek202303.ui.theme.Geek202303Theme
import com.example.geek202303.viewmodel.TripListState
import com.example.geek202303.viewmodel.TripListViewModel
import com.example.geek202303.viewmodel.TripState

@Composable
fun TripList(
    viewModel: TripListViewModel = hiltViewModel(),
) {
    /**
     * ViewModelで保持しているStateを監視
     * 変化があった場合は再コンポーズされる
     */
    val state by viewModel.state.collectAsState()

    /**
     * ViewModelがこの関数内だけで使用するため，
     * ViewModelにイベントを渡す場合は，Eventを送るためのリスナーを渡している
     */
    TripList(
        state = state,
        onClickTrip = { viewModel.onEvent(UpdateListEvent) }
    )
}

@Composable
fun TripList(
    state: TripListState,
    onClickTrip: () -> Unit
) {
    Column() {
        Button(
            onClick = { onClickTrip() },
        ) {
            Text(
                text = stringResource(id = R.string.update_list),
                style = MaterialTheme.typography.body2
            )
        }
        LazyColumn(){
            items(state.tripList) { trip ->
                TripCard(trip)
            }
        }
    }

}

@Composable
@Preview
fun TripListPreview(){
    val mockList = TripListState(
        List<TripState>(size = 5) {
            TripState(
                id = 1,
                hostName = "ユリタニ",
                hostId = "qswsedrf",
                carLicense = "86-38",
                carName = "トヨタ・ラクティス",
                passengerLimit = 4,
                locationFrom = "五稜郭タワー",
                locationTo = "はこだて未来大学"
            )
        }
    )

    Geek202303Theme() {
        TripList(
            state = mockList,
            onClickTrip = {}
        )
    }
}

@Composable
fun TripCard(trip: TripState){
    Column(modifier = Modifier.padding(all = 8.dp)) {
        Text(
            text = trip.id.toString(),
            style = MaterialTheme.typography.body2
        )
        Text(
            text = trip.hostId,
            style = MaterialTheme.typography.body2
        )
        Text(
            text = trip.hostName,
            style = MaterialTheme.typography.body2
        )
        Text(
            text = trip.carLicense,
            style = MaterialTheme.typography.body2
        )
        Text(
            text = trip.carName,
            style = MaterialTheme.typography.body2
        )
        Text(
            text = trip.passengerLimit.toString(),
            style = MaterialTheme.typography.body2
        )
        Text(
            text = trip.locationFrom,
            style = MaterialTheme.typography.body2
        )
        Text(
            text = trip.locationTo,
            style = MaterialTheme.typography.body2
        )
    }
}

@Preview
@Composable
fun TripCardPreview(){
    val mockData = TripState(
        id = 1,
        hostName = "ユリタニ",
        hostId = "qswsedrf",
        carLicense = "86-38",
        carName = "トヨタ・ラクティス",
        passengerLimit = 4,
        locationFrom = "五稜郭タワー",
        locationTo = "はこだて未来大学"
    )
    androidx.compose.material.Surface() {
        TripCard(mockData)
    }
}