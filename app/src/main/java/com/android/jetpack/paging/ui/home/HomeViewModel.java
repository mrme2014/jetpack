package com.android.jetpack.paging.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {


    private final LiveData pageData;

    public HomeViewModel() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(10)//设置每次分页加载的条数
                .setInitialLoadSizeHint(12)//设置初始数据加载的条数
                // .setMaxSize(100)；//如果知道最多有多少条数据，可以在此设置，仅仅只对DataSource使用PositionKeyedDataSource时有效
                // .setEnablePlaceholders(false)//搭配上面的，列表快速滑动时，未加载出来的条目 是否启用占位符
                // .setPrefetchDistance()//分页预加载的距离，默认跟pageSize一样。即<=10个未加载到屏幕上时，就开始加载下一页了
                .build();

         pageData = new LivePagedListBuilder(factory, config)
                .setInitialLoadKey(0)//初始化数据加载的key。可以是任意对象
                //.setFetchExecutor()
                .setBoundaryCallback(boundaryCallback)//边界回调的callback
                .build();
    }


    public LiveData getPageData() {
        return pageData;
    }

    DataSource.Factory factory = new DataSource.Factory() {
        @NonNull
        @Override
        public DataSource create() {
            return new DataSource();
        }
    };

    PagedList.BoundaryCallback boundaryCallback = new PagedList.BoundaryCallback() {
        @Override
        public void onZeroItemsLoaded() {
            //分页数据为空时回调
        }

        @Override
        public void onItemAtFrontLoaded(@NonNull Object itemAtFront) {
            //pagedList持有的数据中第一条数据被加载到屏幕上时 回调
        }

        @Override
        public void onItemAtEndLoaded(@NonNull Object itemAtEnd) {
            //pagedList持有的数据中最后一条数据被加载到屏幕上时 回调
        }
    };

    //两个泛型,key 为分页的入参类型,value 为返回值的数据类型
    class DataSource extends PageKeyedDataSource<Integer, String> {
        @Override
        public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, String> callback) {
            //初始化数据的加载
        }

        @Override
        public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, String> callback) {
            //向前分页
        }

        @Override
        public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, String> callback) {
            //向后分页
        }

        private void loadData(int page, LoadCallback<Integer, String> callback) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                result.add("页码:" + page + ",index:" + i);
            }
            //模拟王楼数据加载完成后，把数据回传给pagedList,第二个参数是告诉它，下一页的页码是什么
            callback.onResult(result, page++);
        }
    }

}