package org.ajeet.learnings.algorithms.graph;

import java.util.List;

public interface IGraph {

    public List<INode> dfs(INode source, INode destination);
    public List<INode> bfs(INode source, INode destination);
    public List<INode> shortestPath(INode source, INode destination);
    public List<INode> aStar(INode source, INode destination);
    public boolean connected(INode source, INode destination);
    public boolean isBipartite();
    public boolean isEmpty();

}
