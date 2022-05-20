package hello.bit.service;

import hello.bit.domain.AdPolicyVO;

import java.util.List;

public interface VdiMgmtservice{

    public List< AdPolicyVO > getAdPolicyList( AdPolicyVO adPolicyVO );

    public int setAdPoilcy( AdPolicyVO adPolicyVO );
}
