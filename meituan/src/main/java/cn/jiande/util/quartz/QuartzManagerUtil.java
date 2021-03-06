package cn.jiande.util.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

/** 
* @author : MT
* @date 创建时间：2017年10月26日 下午5:34:44 
* @version 1.0 
*/
@SuppressWarnings({ "unchecked", "rawtypes" })
public class QuartzManagerUtil {

	private static SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();
	private static String JOB_GROUP_NAME = "EXTJWEB_JOBGROUP_NAME";
	private static String TRIGGER_GROUP_NAME = "EXTJWEB_TRIGGERGROUP_NAME";

	/**  
	 * @Description: 添加一个定时任务，使用默认的任务组名，触发器名，触发器组名  
	 *   
	 * @param jobName  
	 *            任务名  
	 * @param cls  
	 *            任务  
	 * @param time  
	 *            时间设置，参考quartz说明文档  
	 *   
	 * @Title: QuartzManager.java  
	 * @Copyright: Copyright (c) 2014  
	 *   
	 * @author MT  
	 * @date 2017年10月26日 下午03:47:44  
	 * @version V2.0  
	 */
	public static void addJob(String jobName, Class cls, String time) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			JobDetail jobDetail = JobBuilder.newJob(cls).withIdentity(jobName, JOB_GROUP_NAME).build();// 任务名，任务组，任务执行类

			CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule(time);
			// 触发器
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, TRIGGER_GROUP_NAME).startNow()
					.withSchedule(builder).build();

			sched.scheduleJob(jobDetail, trigger);
			// 启动
			if (!sched.isShutdown()) {
				sched.start();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**  
	 * @Description: 添加一个定时任务  
	 *   
	 * @param jobName  
	 *            任务名  
	 * @param jobGroupName  
	 *            任务组名  
	 * @param triggerName  
	 *            触发器名  
	 * @param triggerGroupName  
	 *            触发器组名  
	 * @param jobClass  
	 *            任务  
	 * @param time  
	 *            时间设置，参考quartz说明文档  
	 *   
	 * @Title: QuartzManager.java  
	 * @Copyright: Copyright (c) 2014  
	 *   
	 * @author MT  
	 * @date 2017年10月26日 下午03:48:15  
	 * @version V2.0  
	 */
	public static void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName,
			Class jobClass, String cron) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			// 任务名，任务组，任务执行类
			JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();

			// 触发器
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
			// 触发器名,触发器组
			triggerBuilder.withIdentity(triggerName, triggerGroupName);
			triggerBuilder.startNow();
			// 触发器时间设定
			triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
			// 创建Trigger对象
			CronTrigger trigger = (CronTrigger) triggerBuilder.build();

			// 调度容器设置JobDetail和Trigger
			sched.scheduleJob(jobDetail, trigger);

			// 启动
			if (!sched.isShutdown()) {
				sched.start();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**  
	 * @Description: 修改一个任务的触发时间(使用默认的任务组名，触发器名，触发器组名)  
	 *   
	 * @param jobName  
	 * @param time  
	 *   
	 * @Title: QuartzManager.java  
	 * @Copyright: Copyright (c) 2014  
	 *   
	 * @author MT  
	 * @date 2017年10月26日 下午03:49:21  
	 * @version V2.0  
	 */
	public static void modifyJobTime(String jobName, String time) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			CronTrigger trigger = (CronTrigger) sched.getTrigger(new TriggerKey(jobName, TRIGGER_GROUP_NAME));
			if (trigger == null) {
				return;
			}
			String oldTime = trigger.getCronExpression();
			if (!oldTime.equalsIgnoreCase(time)) {
				JobDetail jobDetail = sched.getJobDetail(new JobKey(jobName, JOB_GROUP_NAME));
				Class objJobClass = jobDetail.getJobClass();
				removeJob(jobName);
				addJob(jobName, objJobClass, time);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/** 
	* @Description: 修改一个任务的触发时间
	*  
	* @param jobName 
	* @param jobGroupName
	* @param triggerName 触发器名
	* @param triggerGroupName 触发器组名 
	* @param cron   时间设置，参考quartz说明文档   
	*/
	public static void modifyJobTime(String jobName, String jobGroupName, String triggerName, String triggerGroupName,
			String cron) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
			CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerKey);
			if (trigger == null) {
				return;
			}

			String oldTime = trigger.getCronExpression();
			if (!oldTime.equalsIgnoreCase(cron)) {
				/** 方式一 ：调用 rescheduleJob 开始 */
				// 触发器
				TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
				// 触发器名,触发器组
				triggerBuilder.withIdentity(triggerName, triggerGroupName);
				triggerBuilder.startNow();
				// 触发器时间设定
				triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
				// 创建Trigger对象
				trigger = (CronTrigger) triggerBuilder.build();
				// 方式一 ：修改一个任务的触发时间
				sched.rescheduleJob(triggerKey, trigger);
				/** 方式一 ：调用 rescheduleJob 结束 */

				/** 方式二：先删除，然后在创建一个新的Job  */
				// JobDetail jobDetail =
				// sched.getJobDetail(JobKey.jobKey(jobName, jobGroupName));
				// Class<? extends Job> jobClass = jobDetail.getJobClass();
				// removeJob(jobName, jobGroupName, triggerName,
				// triggerGroupName);
				// addJob(jobName, jobGroupName, triggerName, triggerGroupName,
				// jobClass, cron);
				/** 方式二 ：先删除，然后在创建一个新的Job */
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/** 
	 * 更新任务时间：先移除、再新增 
	 * @param triggerName 
	 * @param triggerGroupName 
	 * @param time 
	 */
	public static void modifyJobTimeTrue(String jobName, String jobGroupName, String triggerName,
			String triggerGroupName, Class jobClass, String time) {
		// 先移除
		removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
		// 再新增
		addJob(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, time);
	}

	/**  
	 * @Description: 移除一个任务(使用默认的任务组名，触发器名，触发器组名)  
	 *   
	 * @param jobName  
	 *   
	 * @Title: QuartzManager.java  
	 * @Copyright: Copyright (c) 2014  
	 *   
	 * @author MT  
	 * @date 2017年10月26日 下午03:49:51  
	 * @version V2.0  
	 */
	public static void removeJob(String jobName) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			sched.pauseTrigger(new TriggerKey(jobName, TRIGGER_GROUP_NAME));// 停止触发器
			sched.unscheduleJob(new TriggerKey(jobName, TRIGGER_GROUP_NAME));// 移除触发器
			sched.deleteJob(new JobKey(jobName, JOB_GROUP_NAME));// 删除任务
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**  
	 * @Description: 移除一个任务  
	 *   
	 * @param jobName  
	 * @param jobGroupName  
	 * @param triggerName  
	 * @param triggerGroupName  
	 *   
	 * @Title: QuartzManager.java  
	 * @Copyright: Copyright (c) 2014  
	 *   
	 * @author MT  
	 * @date 2017年10月26日 下午03:50:01  
	 * @version V2.0  
	 */
	public static void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();

			TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);

			sched.pauseTrigger(triggerKey);// 停止触发器
			sched.unscheduleJob(triggerKey);// 移除触发器
			sched.deleteJob(JobKey.jobKey(jobName, jobGroupName));// 删除任务
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**  
	 * @Description:启动所有定时任务  
	 *   
	 *   
	 * @Title: QuartzManager.java  
	 * @Copyright: Copyright (c) 2014  
	 *   
	 * @author MT  
	 * @date 2017年10月26日 下午03:50:18  
	 * @version V2.0  
	 */
	public static void startJobs() {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			sched.start();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**  
	 * @Description:关闭所有定时任务  
	 *   
	 *   
	 * @Title: QuartzManager.java  
	 * @Copyright: Copyright (c) 2014  
	 *   
	 * @author MT  
	 * @date 2017年10月26日 下午03:50:26  
	 * @version V2.0  
	 */
	public static void shutdownJobs() {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			if (!sched.isShutdown()) {
				sched.shutdown();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**  
	 * 停止一个job任务  
	 * @param jobkey  
	 * @throws SchedulerException  
	 */
	public static void pauseJob(String jobName, String groupName/*, String triggerName*/) throws SchedulerException {
		Scheduler sched = gSchedulerFactory.getScheduler();
		// sched.pauseTrigger(triggerName, groupName);
		// sched.pauseJob(jobName, groupName);
		sched.interrupt(new JobKey(jobName, groupName));
	}

	/**  
	 * 恢复相关的job任务  
	 * @param jobkey  
	 * @throws SchedulerException  
	 */
	public static void resumeJob(String jobName, String groupName/*, String triggerName*/) throws SchedulerException {
		Scheduler sched = gSchedulerFactory.getScheduler();
		// sched.resumeTrigger(triggerName, groupName);
		sched.resumeJob(new JobKey(jobName, groupName));
	}
}
