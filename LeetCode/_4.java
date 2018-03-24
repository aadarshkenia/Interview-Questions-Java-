class _4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     	int m = nums1.length;
     	int n = nums2.length;

	if(m == 0) {
		//Return median of nums2
		if(n == 0) return 0.0;
		else return n%2 == 0 ? (nums2[n/2] + nums2[n/2 + 1]) /2.0 : nums2[n/2];
	} else if( n == 0) {
		//Return median of nums1
		return m%2 == 0 ? (nums1[m/2] + nums1[m/2 + 1]) /2.0 : nums1[m/2];
	} else {
		//Iterate
		int low = 0, hi = m-1;
		int half = (m + n) /2;
		while(low < hi) {
			int i = low + (hi - low)/2;
			int j = half - i;
			
			if(j > 0) {
				if(nums1[i] < nums2[j-1]) {
					low = i + 1;
					continue;
				}
			}

			if(i > 0) {
				if(nums1[i-1] > nums2[j]) {
					hi = i - 1;
					continue;
				}
			}


			if(i > 0 && j > 0) {
				if(nums1[i] < nums2[j-1]) {
					low = i + 1;
				} else if(nums1[i-1] > nums2[j]) {
					hi = i - 1;
				} else { //Found perfect match.					
					//Get num of elems to left, num of elems to right.
					int leftElems = i + j;
					int rightElems = m + n - i - j;
					if(leftElems == rightElems) return (Math.max(nums1[i-1], nums2[j-1]) + Math.min(nums1[i], nums2[j])) / 2.0;
					else return leftElems > rightElems ? Math.max(nums1[i-1], nums2[j-1] : Math.min(nums1[i], nums2[j]);
				}
			} else if (i > 0 ) {

			}
		}
	}


    }	
}

