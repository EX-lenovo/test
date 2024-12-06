package com.example.testapplication;

import com.example.testapplication.room.RoomTestEntity;

/**
 * com.example.testapplication
 * created: cuizj4
 * at : 2024/6/13-15:24
 * desc:
 * version : 1.0.0
 */
public class Test {
    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
    public static void main(String[] args) throws InterruptedException {

        RoomTestEntity entity=new RoomTestEntity();
        System.out.println(entity);
//
//
//
//
//
//
//        System.out.println("main " + Thread.currentThread().getName());
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(i);
//        }
//
//        Flowable.just(1)
//                .map(new Function<Integer, Object>() {
//                    @Override
//                    public Object apply(Integer integer) throws Throwable {
//                        if (1==1){
//                            throw new MyException();
//                        }
//
//                        return null;
//                    }
//                })
//                .subscribeWith(new FlowableSubscriber<Object>() {
//                    @Override
//                    public void onSubscribe(@NonNull Subscription s) {
//                        s.request(1);
//                    }
//
//                    @Override
//                    public void onNext(Object o) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        if (t instanceof MyException){
//                            System.out.println("捕获");
//                        }
//                        System.out.println(t);
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//        Flowable.just(1)
//                .flatMap(new )
//        Flowable.just(100)
//                .flatMap(new Function<Integer, Flowable<Integer>>() {
//                    @Override
//                    public Flowable<Integer> apply(Integer integer) throws Throwable {
//                        System.out.println("flatMap " + Thread.currentThread().getName());
//                        return Flowable.fromIterable(list);
//                    }
//                })
//                .map(new Function<Integer, Object>() {
//                    @Override
//                    public Object apply(Integer integer) throws Throwable {
//                        System.out.println("map " + Thread.currentThread().getName() + "," + integer);
//                        return integer * integer;
//                    }
//                })
//                .toList().toFlowable()
//                .subscribeOn(Schedulers.computation())
//                .observeOn(Schedulers.io())
//                .subscribeWith();
//                .subscribe(new FlowableSubscriber<List<Object>>() {
//                    @Override
//                    public void onSubscribe(@NonNull Subscription s) {
//                        s.request(list.size());
//                    }
//
//                    @Override
//                    public void onNext(List<Object> objects) {
//                        System.out.println("onNext " + Thread.currentThread().getName());
//                        System.out.println(objects.get(0));
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

        Thread.sleep(40000);

    }

    static class MyException extends RuntimeException{
        MyException(){
            super("都是我的错");
        }
    }
}
