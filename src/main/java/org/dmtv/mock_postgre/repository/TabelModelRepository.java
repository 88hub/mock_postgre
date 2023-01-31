package org.dmtv.mock_postgre.repository;

import org.dmtv.mock_postgre.model.TabelModel;


public interface TabelModelRepository {
    TabelModel selectByLogin(String login);
    int insertTabelInfo(TabelModel tb);

}
