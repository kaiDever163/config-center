package org.example.client;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.apache.zookeeper.data.Stat;

    public class Zookpeer {
        public static String CONNECTSTRING= "127.0.0.1:2181";
        public static String PATH= "/crud";
        public static String NAMESPACE= "fortest";
        public static void main(String[] args) {

            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
            CuratorFramework client;

            //      client= CuratorFrameworkFactory.newClient(CONNECTSTRING, retryPolicy);

            client=CuratorFrameworkFactory. builder().
                    connectString( CONNECTSTRING )
                    .connectionTimeoutMs(30000)
                    .sessionTimeoutMs(30000)
                    .canBeReadOnly( false ).retryPolicy(retryPolicy)
                    .namespace( NAMESPACE )
                    .defaultData( null )
                    .build();
            client.start();

            try {
                client.create().forPath( PATH ,"hello world".getBytes());
                byte [] bs=client.getData().forPath( PATH);
                System. out .println("新建的节点,data为: " + new String(bs));

                client.setData().forPath( PATH ,"hello china".getBytes());
                // 由于是在background模式下获取的data，此时的 bs可能为null
                byte [] bs2=client.getData().watched().inBackground().forPath( PATH);
                System. out .println("新修改的节点,data为: " + new String(bs2!=null ? bs2 : new byte[2]));

                client.delete().forPath( PATH );
                Stat stat=client.checkExists().forPath( PATH );
                // Stat 就是对zonde所有属性的一个映射， stat=null表示节点不存在！
                System.out.println(stat);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                CloseableUtils. closeQuietly(client);
            }
        }
    }
