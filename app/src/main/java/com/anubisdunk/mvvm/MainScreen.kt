import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anubisdunk.mvvm.FirstScreen
import com.anubisdunk.mvvm.R
import com.anubisdunk.mvvm.calculator.CalcViewModel
import com.anubisdunk.mvvm.calculator.Calculator
import com.anubisdunk.mvvm.converter.ConverterScreen
import com.anubisdunk.mvvm.retrofitJokes.JokesScreen
import com.anubisdunk.mvvm.retrofitJokes.JokesViewModel
import com.anubisdunk.mvvm.retrofitJokes.api.RetrofitInstance
import com.anubisdunk.mvvm.retrofitJokes.repo.JokesRepo
import com.anubisdunk.mvvm.skins.Skins
import com.anubisdunk.mvvm.states.StatesScreen
import com.anubisdunk.mvvm.ui.GameViewModel
import kotlinx.coroutines.launch

enum class AppScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    State(title = R.string.statesScr),
    Calculator(title = R.string.calcScr),
    Skins(title = R.string.heroesScr),
    Conv(title = R.string.converterScr),
    Jokes(title = R.string.jokesScr)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    val viewModel = viewModel<GameViewModel>()
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var text = viewModel.userInput


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Select playground", modifier = Modifier.padding(16.dp))
                Divider()
                DrawerItem(
                    onClick = {
                        navController.navigate(AppScreen.Start.name)
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = Icons.Filled.Home,
                    text = "Jetpack Compose Playground"
                )
                DrawerItem(
                    onClick = {
                        navController.navigate(AppScreen.State.name)
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = Icons.Filled.List,
                    text = "Idk"
                )
                DrawerItem(
                    onClick = {
                        navController.navigate(AppScreen.Calculator.name)
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = Icons.Filled.Phone,
                    text = "Calculator"
                )
                DrawerItem(
                    onClick = {
                        navController.navigate(AppScreen.Skins.name)
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = Icons.Filled.Face,
                    text = "Skins"
                )
                DrawerItem(
                    onClick = {
                        navController.navigate(AppScreen.Conv.name)
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = Icons.Filled.Place,
                    text = "Converter"
                )
                DrawerItem(
                    onClick = {
                        navController.navigate(AppScreen.Jokes.name)
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = Icons.Filled.Send,
                    text = AppScreen.Jokes.name
                )
            }
        },
        gesturesEnabled = true,
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = viewModel.titleText) },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
                        }
                    },

                    )
            }
        ) { it ->
            Column(
                modifier = Modifier.padding(it),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                DisplayNav(viewModel, navController)
            }
        }
    }
}

@Composable
fun DisplayNav(
    viewModel: GameViewModel,
    navController: NavHostController
) {


    NavHost(
        navController = navController,
        startDestination = AppScreen.Start.name
    ) {
        composable(route = AppScreen.Start.name) {
            viewModel.titleText = "Jetpack Compose Playground"
            FirstScreen(viewModel)
        }
        composable(route = AppScreen.State.name) {
            viewModel.titleText = "States"
            StatesScreen()
        }
        composable(route = AppScreen.Calculator.name) {
            viewModel.titleText = "Calculator"
            Calculator()
        }
        composable(route = AppScreen.Skins.name) {
            viewModel.titleText = "Skins"
            Skins()
        }
        composable(route = AppScreen.Conv.name) {
            viewModel.titleText = "Converter"
            ConverterScreen()
        }
        composable(route = AppScreen.Jokes.name) {
            viewModel.titleText = "Jokes"
            JokesScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerItem(
    onClick: () -> Unit,
    icon: ImageVector,
    text: String
) {

    NavigationDrawerItem(
        label = {
            Row {
                Icon(
                    imageVector = icon,
                    contentDescription = null
                )
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = text
                )
            }
        },
        selected = false,
        onClick = { onClick() }
    )
}