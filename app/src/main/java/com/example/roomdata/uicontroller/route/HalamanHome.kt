package com.example.roomdata.view

package com.example.myroomsiswa.view

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToItemEntry: () -> Unit,
    //edit 5
    navigateToItemUpdate: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            SiswaTopAppBar(
                title = stringResource(DestinasiHome.titleRes),
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToItemEntry,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.entry_siswa)
                )
            }
        }
    ){ innerPadding ->
        val uiStateSiswa by viewModel.homeUiState.collectAsState()
        BodyHome(
            itemSiswa = uiStateSiswa.listSiswa,
            //edit 6
            onSiswaClick = navigateToItemUpdate,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
}

@Composable
fun BodyHome(
    itemSiswa: List<Siswa>,
    //edit 3 : parameter onSiswaClick
    onSiswaClick: (Int) -> Unit,
    modifier: Modifier=Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        if (itemSiswa.isEmpty()){
            Text(
                text = stringResource(R.string.deskripsi_no_item),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListSiswa(
                itemSiswa = itemSiswa,
                //edit 4
                onSiswaClick = {onSiswaClick(it.id)},
                modifier = Modifier.padding(horizontal = dimensionResource(id =
                    R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun ListSiswa(
    itemSiswa : List<Siswa>,
    //edit 1 : tambahkan parameter onSiswaClick
    onSiswaClick: (Siswa) -> Unit,
    modifier: Modifier=Modifier
){
    LazyColumn(modifier = Modifier){
        items(items = itemSiswa, key = {it.id}){
                person ->
            DataSiswa(
                siswa = person,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    //edit2 : tambahkan modifikasi clickable
                    .clickable { onSiswaClick(person) })
        }
    }
}

@Composable
fun DataSiswa(
    siswa: Siswa,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ){
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ){
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = siswa.nama,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Phone ,
                    contentDescription = null,
                )
                Text(
                    text = siswa.telpon,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Text(
                text = siswa.alamat,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}