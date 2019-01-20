package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.dao.impl.BucketDaoImpl;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.service.BucketService;

public class BucketServiceImpl implements BucketService {
	private static Logger LOGGER = Logger.getLogger(BucketServiceImpl.class);
	private static BucketService bucketServiceImpl;
	private BucketDao bucketDao;

	private BucketServiceImpl() {
		try {
			bucketDao = new BucketDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}

	public static BucketService getBucketService() {
		if (bucketServiceImpl == null) {
			bucketServiceImpl = new BucketServiceImpl();
		}

		return bucketServiceImpl;
	}

	@Override
	public Bucket create(Bucket t) {
		return bucketDao.create(t);
	}

	@Override
	public Bucket read(Integer id) {
		return bucketDao.read(id);
	}

	@Override
	public Bucket update(Bucket t) {
		return bucketDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		bucketDao.delete(id);
	}

	@Override
	public List<Bucket> readAll() {
		return bucketDao.readAll();
	}

}
