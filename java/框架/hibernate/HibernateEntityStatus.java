package hibernate;

/**
 * @Description: hibernate实体的三种状态
 * @Author: wangwenjie
 * @CreateTime: 2019-11-28 09:13
 */
public class HibernateEntityStatus {
    /**
     * hibernate实体类的三种状态
     * 1.瞬时态，临时态，自由态，由new命令创建，开辟内存空间的对象，
     *  不存在持久化oid（相当于主键），与hibernate session无关联
     * 2.持久态，存在OID，并且与session有关联
     *      持久态对象，在发生修改时，当session关闭时，会发生update
     *      hibernate一级缓存的值发生了改变，对应的快照区中的值为源数据，发现两处数据不同时，会将数据update到数据库
     * 3.脱管态，离线态或者游离态，有id，与session无关联，脱管态，实体改变，hibernate不能检测到
     */
}
